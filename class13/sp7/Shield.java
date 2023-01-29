/***
 *** Ship�̃V�[���h
 ***/
import java.awt.*;

public class Shield extends GameChar {
  private int sld_cnt; // �V�[���h�J�E���g

  // ����
  public Shield(double x,double y){
    super(x,y);
    sld_cnt=0;
  }

  // �`��
  public void draw(Graphics g){
    if(sld_cnt%3>0) return;
    int s=sld_cnt*2;
    g.setColor(Color.cyan);
    g.drawOval((int)px-s,(int)py-s,2*s,2*s);
  }

  // �L����
  public boolean spread(){
    return sld_cnt++<30; // 30��L�����������
  }
}
