/***
 *** �G�̒��ۊ��N���X
 ***/
import java.awt.*;

public abstract class Enemy extends GameChar {

  // �`��
  public abstract void draw(Graphics g);

  // �ړ�
  public abstract boolean move(int w,int h,double tx,double ty);

  // ���e�𗎂Ƃ�
  public abstract void dropBomb(double sx,double sy,GameManager gm);

  // �_���𓾂�
  public abstract int getScore();
}
