import java.awt.*;

public class Beam extends GameChar {
  private double vx,vy; // ���x

  // ����
  public Beam(double x,double y){
    super(x,y); // �ʒu��x,y
    setSize(6,8);
    vx=0; // ���x�͏��-8����
    vy=-8;
  }

  // �ړ�
  // ��ʓ��ɂ��邩�ǂ�����Ԃ�
  public boolean move(){
    if(!alive) return false; // ���񂾂����
    px+=vx; // �ړ�
    py+=vy;
    if(py<-4) return false; // ��ʊO�ɏo�������
    return true; // �܂���ʓ�
  }

  // �`��
  public void draw(Graphics g){
    g.setColor(Color.yellow); // ���F�ŁA
    g.fillRect((int)px-3,(int)py-4,6,8); // �������l�p��`��
  }
}
