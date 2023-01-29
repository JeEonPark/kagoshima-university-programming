/***
 *** �Q�[���L�����N�^�[
 ***/
import java.awt.*;

public abstract class GameChar {
  protected double px,py; // �ʒu
  private double cw,ch; // ����̈�̑傫��
  protected boolean alive; // �����t���O
  
  // ����
  public GameChar(){
    this(0,0);
  }
  public GameChar(double x,double y){
    px=x; py=y;
    cw=ch=0; // �ŏ��̑傫����0x0
    alive=true; // �ŏ��͐����Ă���
  }

  // �傫���ݒ�
  public void setSize(double w,double h){
    cw=w;
    ch=h;
  }

  // �ʒu�𓾂�
  public double getX(){ return px; }
  public double getY(){ return py; }

  // �d�Ȃ蔻��
  public boolean overlap(GameChar c){
    double x11=px-cw/2,y11=py-ch/2;
    double x12=px+cw/2,y12=py+ch/2;
    double x21=c.px-c.cw/2,y21=c.py-c.ch/2;
    double x22=c.px+c.cw/2,y22=c.py+c.ch/2;
    return
      (((x11<=x21 && x21<x12)||(x21<=x11 && x11<x22)) &&
       ((y11<=y21 && y21<y12)||(y21<=y11 && y11<y22)));
  }

  // ����
  public void die(){
    alive=false;
  }
}
