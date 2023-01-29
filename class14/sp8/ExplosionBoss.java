/***
 *** É{ÉXîöî≠
 ***/
import java.awt.*;

public class ExplosionBoss extends Explosion {

  // ê∂ê¨
  public ExplosionBoss(){
    super(0,0);
  }

  // ï`âÊ
  public void draw(Graphics g){
    int b=255*exp_cnt/50;
    g.setColor(new Color(255,255,255,b));
    g.fillRect(0,0,600,600);
  }

  // çLÇ∞ÇÈ
  public boolean spread(){
    return exp_cnt++<50;
  }
}
