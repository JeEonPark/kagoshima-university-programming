import java.awt.*;

public class Beam extends GameChar {
  private double vx,vy; // 速度

  // 生成
  public Beam(double x,double y){
    super(x,y); // 位置はx,y
    setSize(6,8);
    vx=0; // 速度は上へ-8ずつ
    vy=-8;
  }

  // 移動
  // 画面内にあるかどうかを返す
  public boolean move(){
    if(!alive) return false; // 死んだら消滅
    px+=vx; // 移動
    py+=vy;
    if(py<-4) return false; // 画面外に出たら消滅
    return true; // まだ画面内
  }

  // 描画
  public void draw(Graphics g){
    g.setColor(Color.yellow); // 黄色で、
    g.fillRect((int)px-3,(int)py-4,6,8); // 小さい四角を描く
  }
}
