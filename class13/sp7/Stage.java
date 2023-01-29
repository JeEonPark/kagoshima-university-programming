/***
 *** ステージの基底クラス
 ***/
import java.awt.*;

public abstract class Stage {
  protected int lap; // 経過時間
  protected int max; // 最大時間
  protected GameManager gm; // ゲーム管理者

  // 生成
  public Stage(GameManager gm){
    lap=0;
    max=0;
    this.gm=gm;
  }

  // 描画（Lapゲージ）
  // max>0のときだけ描画する
  public void draw(Graphics g){
    if(max>0){
      if(lap>0){ // 半透明で塗られたゲージ
        g.setColor(new Color(0,255,180,128));
        int w=400*lap/max;
        g.fillRect(150,20,w,10);
      }
      g.setColor(Color.white);
      g.drawRect(150,20,400,10);
    }
  }

  // 進行
  public abstract boolean proceed(int w,int h,double sx,double sy);

  // 次のステージ
  public abstract Stage next();
}
