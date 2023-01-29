/***
 *** 敵1
 *** 下にゆっくり移動
 *** Shipへ向けてBombを投下
 ***/
import java.awt.*;

public class Enemy1 extends Enemy {
  private double vel_max=4; // 最大移動速度
  private double size_min=5,size_max=8; // 大きさの範囲

  private double vx,vy; // 速度
  private double size; // 大きさ
  private double ds=1; // 大きさの変化量
  
  // 生成
  // ゲーム画面上部にどこかで生成し、下部のどこかに向けて移動
  public Enemy1(int w,int h){
    size=(size_max+size_min)/2; // 初期サイズは真ん中
    setSize(2*size,2*size); // 当たり判定用の大きさをセット
    px=Math.random()*w; // 画面上のどこかから
    py=0;
    double tx=Math.random()*w; // 画面下のどこか
    double ty=h;
    double dx=tx-px,dy=ty-py; // に向けて
    double d=Math.sqrt(dx*dx+dy*dy); // 移動ベクトルを
    vx=dx*vel_max/d; // 作る
    vy=dy*vel_max/d;
  }

  // 描画
  public void draw(Graphics g){
    g.setColor(Color.green);
    g.fillRect((int)(px-size),(int)(py-size),(int)(2*size),(int)(2*size));
  }

  // 移動
  public boolean move(int w,int h,double tx,double ty){
    if(!alive) return false; // 死んだら消滅
    px+=vx; // 移動
    py+=vy;
    if(px<0 || px>w) // 左右の壁で
      vx=-vx; // 跳ね返る
    size+=ds; // 大きさを変える
    setSize(2*size,2*size); // 当たり判定用の大きさをセット
    if(size<size_min || size>size_max) // 大きさが範囲を越えたら
      ds=-ds; // 大きさの変化量の向きを変える
    if(py>h) return false; // 画面外に出た
    return true; // まだ画面内
  }

  // 爆弾を落とす
  public void dropBomb(double sx,double sy,GameManager gm){
    if(Math.random()>0.05) return;
    gm.addBomb(new Bomb(px,py,sx,sy));
  }

  // 点数を得る
  public int getScore(){
    return 10;
  }
}
