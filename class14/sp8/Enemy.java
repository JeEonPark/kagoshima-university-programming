/***
 *** “G‚Ì’ŠÛŠî’êƒNƒ‰ƒX
 ***/
import java.awt.*;

public abstract class Enemy extends GameChar {

  // •`‰æ
  public abstract void draw(Graphics g);

  // ˆÚ“®
  public abstract boolean move(int w,int h,double tx,double ty);

  // ”š’e‚ğ—‚Æ‚·
  public abstract void dropBomb(double sx,double sy,GameManager gm);

  // “_”‚ğ“¾‚é
  public abstract int getScore();
}
