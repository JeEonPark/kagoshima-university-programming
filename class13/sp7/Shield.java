/***
 *** Shipのシールド
 ***/
import java.awt.*;

public class Shield extends GameChar {
  private int sld_cnt; // シールドカウント

  // 生成
  public Shield(double x,double y){
    super(x,y);
    sld_cnt=0;
  }

  // 描画
  public void draw(Graphics g){
    if(sld_cnt%3>0) return;
    int s=sld_cnt*2;
    g.setColor(Color.cyan);
    g.drawOval((int)px-s,(int)py-s,2*s,2*s);
  }

  // 広げる
  public boolean spread(){
    return sld_cnt++<30; // 30回広がったら消滅
  }
}
