/***
 *** �X�e�[�W�̊��N���X
 ***/
import java.awt.*;

public abstract class Stage {
  protected int lap; // �o�ߎ���
  protected int max; // �ő厞��
  protected GameManager gm; // �Q�[���Ǘ���

  // ����
  public Stage(GameManager gm){
    lap=0;
    max=0;
    this.gm=gm;
  }

  // �`��iLap�Q�[�W�j
  // max>0�̂Ƃ������`�悷��
  public void draw(Graphics g){
    if(max>0){
      if(lap>0){ // �������œh��ꂽ�Q�[�W
        g.setColor(new Color(0,255,180,128));
        int w=400*lap/max;
        g.fillRect(150,20,w,10);
      }
      g.setColor(Color.white);
      g.drawRect(150,20,400,10);
    }
  }

  // �i�s
  public abstract boolean proceed(int w,int h,double sx,double sy);

  // ���̃X�e�[�W
  public abstract Stage next();
}
