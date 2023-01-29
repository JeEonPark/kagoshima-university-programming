/***
 *** �G1
 *** ���ɂ������ړ�
 *** Ship�֌�����Bomb�𓊉�
 ***/
import java.awt.*;

public class Enemy1 extends Enemy {
  private double vel_max=4; // �ő�ړ����x
  private double size_min=5,size_max=8; // �傫���͈̔�

  private double vx,vy; // ���x
  private double size; // �傫��
  private double ds=1; // �傫���̕ω���
  
  // ����
  // �Q�[����ʏ㕔�ɂǂ����Ő������A�����̂ǂ����Ɍ����Ĉړ�
  public Enemy1(int w,int h){
    size=(size_max+size_min)/2; // �����T�C�Y�͐^��
    setSize(2*size,2*size); // �����蔻��p�̑傫�����Z�b�g
    px=Math.random()*w; // ��ʏ�̂ǂ�������
    py=0;
    double tx=Math.random()*w; // ��ʉ��̂ǂ���
    double ty=h;
    double dx=tx-px,dy=ty-py; // �Ɍ�����
    double d=Math.sqrt(dx*dx+dy*dy); // �ړ��x�N�g����
    vx=dx*vel_max/d; // ���
    vy=dy*vel_max/d;
  }

  // �`��
  public void draw(Graphics g){
    g.setColor(Color.green);
    g.fillRect((int)(px-size),(int)(py-size),(int)(2*size),(int)(2*size));
  }

  // �ړ�
  public boolean move(int w,int h,double tx,double ty){
    if(!alive) return false; // ���񂾂����
    px+=vx; // �ړ�
    py+=vy;
    if(px<0 || px>w) // ���E�̕ǂ�
      vx=-vx; // ���˕Ԃ�
    size+=ds; // �傫����ς���
    setSize(2*size,2*size); // �����蔻��p�̑傫�����Z�b�g
    if(size<size_min || size>size_max) // �傫�����͈͂��z������
      ds=-ds; // �傫���̕ω��ʂ̌�����ς���
    if(py>h) return false; // ��ʊO�ɏo��
    return true; // �܂���ʓ�
  }

  // ���e�𗎂Ƃ�
  public void dropBomb(double sx,double sy,GameManager gm){
    if(Math.random()>0.05) return;
    gm.addBomb(new Bomb(px,py,sx,sy));
  }

  // �_���𓾂�
  public int getScore(){
    return 10;
  }
}
