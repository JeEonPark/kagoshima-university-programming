import java.awt.*;

public class Bomb extends GameChar {
  private double vel_max=4;
  private double vx,vy;
  
  // 生成
  public Bomb(double x,double y,double tx,double ty){
    super(x,y);
    setSize(4,4);
    double dx=tx-px,dy=ty-py;
    double d=Math.sqrt(dx*dx+dy*dy);
    vx=dx*vel_max/d;
    vy=dy*vel_max/d;
  }

  // 描画
  public void draw(Graphics g){
    g.setColor(Color.red);
    g.fillOval((int)px-2,(int)py-2,4,4);
  }
  
  // 移動
  public boolean move(int w,int h){
    if(!alive) return false; // 死んだら消滅
    px+=vx; // 移動する
    py+=vy;
    if(px<0 || py<0 || px>w || py>h) return false; // 画面外なら消滅
    return true;
  }
}
