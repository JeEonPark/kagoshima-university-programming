/***
 *** ゲームキャラクター
 ***/
import java.awt.*;

public abstract class GameChar {
  protected double px,py; // 位置
  private double cw,ch; // 判定領域の大きさ
  protected boolean alive; // 生存フラグ
  
  // 生成
  public GameChar(){
    this(0,0);
  }
  public GameChar(double x,double y){
    px=x; py=y;
    cw=ch=0; // 最初の大きさは0x0
    alive=true; // 最初は生きている
  }

  // 大きさ設定
  public void setSize(double w,double h){
    cw=w;
    ch=h;
  }

  // 位置を得る
  public double getX(){ return px; }
  public double getY(){ return py; }

  // 重なり判定
  public boolean overlap(GameChar c){
    double x11=px-cw/2,y11=py-ch/2;
    double x12=px+cw/2,y12=py+ch/2;
    double x21=c.px-c.cw/2,y21=c.py-c.ch/2;
    double x22=c.px+c.cw/2,y22=c.py+c.ch/2;
    return
      (((x11<=x21 && x21<x12)||(x21<=x11 && x11<x22)) &&
       ((y11<=y21 && y21<y12)||(y21<=y11 && y11<y22)));
  }

  // 死ぬ
  public void die(){
    alive=false;
  }
}
