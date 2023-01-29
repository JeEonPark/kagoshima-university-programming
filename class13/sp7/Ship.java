/***
 *** シップクラス
 ***/
import java.awt.*;
import java.awt.event.*;

public class Ship extends GameChar implements MouseListener,MouseMotionListener {
  private double vel_max=8; // 最大速度
  private int mx,my; // マウス座標
  private boolean m_down; // マウスボタン状態
  private int shield_cnt; // シールド残数
  private boolean won; // 勝利フラグ
  
  // 生成
  public Ship(int x,int y){
    super(x,y);
    setSize(16,16);
    mx=x;
    my=y;
    m_down=false; // 最初はボタンが押されていない状態
    shield_cnt=10; // シールドは10回まで
    won=false; // 勝ってない
  }

  // 移動
  public void move(){
    double vx=mx-px;
    double vy=my-py;
    double vel=Math.sqrt(vx*vx+vy*vy);
    if(vel>vel_max){
      vx=vx*vel_max/vel;
      vy=vy*vel_max/vel;
    }
    px+=vx;
    py+=vy;
  }

  // 発射
  public void shot(GameManager gm){
    if(alive && m_down) // ボタンが押されていれば、
      gm.addBeam(new Beam(px,py)); // ビームを生成して追加する
  }

  // 描画
  public void draw(Graphics g){
    if(!alive) return; // 死んでいるときは描画しない
    int[] x={ (int)px,(int)px-10,(int)px+10 };    // 三角形の頂点X座標
    int[] y={ (int)py-15,(int)py+10,(int)py+10 }; // 三角形の頂点Y座標
    g.setColor(new Color(255,255,100)); // 明るい黄色で
    g.fillPolygon(x,y,3);               // 塗りつぶして
    g.setColor(new Color(255,200,20));  // 暗い黄色で
    g.drawPolygon(x,y,3);               // 枠を描く

    // シールド
    g.setColor(new Color(0,200,255,128));
    for(int i=0;i<shield_cnt;i++){
      int x1=i*22+20;
      g.fillRect(x1,530,20,10);
    }
  }

  // ダメージを受ける
  public boolean damage(){
    if(shield_cnt>0) shield_cnt--;
    alive=(shield_cnt>0);
    return !alive;
  }

  // 重なり判定
  public boolean overlap(GameChar c){
    if(!alive || won) return false;
    return super.overlap(c);
  }

  // 勝つ
  public void win(){
    won=true;
  }

  // マウスリスナー
  public void mousePressed(MouseEvent ev){
    m_down=true; // ボタンが押されている状態
  }
  public void mouseReleased(MouseEvent ev){
    m_down=false; // ボタンが押されていない状態
  }
  public void mouseClicked(MouseEvent ev){}
  public void mouseEntered(MouseEvent ev){}
  public void mouseExited(MouseEvent ev){}
  public void mouseMoved(MouseEvent ev){
    mx=ev.getX(); // マウス座標を更新
    my=ev.getY();
  }
  public void mouseDragged(MouseEvent ev){
    mx=ev.getX(); // マウス座標を更新
    my=ev.getY();
  }
}
