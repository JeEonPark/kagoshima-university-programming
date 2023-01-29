/***
 *** �V�b�v�N���X
 ***/
import java.awt.*;
import java.awt.event.*;

public class Ship extends GameChar implements MouseListener,MouseMotionListener {
  private double vel_max=8; // �ő呬�x
  private int mx,my; // �}�E�X���W
  private boolean m_down; // �}�E�X�{�^�����
  private int shield_cnt; // �V�[���h�c��
  private boolean won; // �����t���O
  
  // ����
  public Ship(int x,int y){
    super(x,y);
    setSize(16,16);
    mx=x;
    my=y;
    m_down=false; // �ŏ��̓{�^����������Ă��Ȃ����
    shield_cnt=10; // �V�[���h��10��܂�
    won=false; // �����ĂȂ�
  }

  // �ړ�
  public void move(){
    double vx=mx-px;
    double vy=my-py;
    double vel=Math.sqrt(vx*vx+vy*vy);
    if(vel>vel_max){
      vx=vx*vel_max/vel;
      vy=vy*vel_max/vel;
    }
    px+=vx;
    py+=vy;
  }

  // ����
  public void shot(GameManager gm){
    if(alive && m_down) // �{�^����������Ă���΁A
      gm.addBeam(new Beam(px,py)); // �r�[���𐶐����Ēǉ�����
  }

  // �`��
  public void draw(Graphics g){
    if(!alive) return; // ����ł���Ƃ��͕`�悵�Ȃ�
    int[] x={ (int)px,(int)px-10,(int)px+10 };    // �O�p�`�̒��_X���W
    int[] y={ (int)py-15,(int)py+10,(int)py+10 }; // �O�p�`�̒��_Y���W
    g.setColor(new Color(255,255,100)); // ���邢���F��
    g.fillPolygon(x,y,3);               // �h��Ԃ���
    g.setColor(new Color(255,200,20));  // �Â����F��
    g.drawPolygon(x,y,3);               // �g��`��

    // �V�[���h
    g.setColor(new Color(0,200,255,128));
    for(int i=0;i<shield_cnt;i++){
      int x1=i*22+20;
      g.fillRect(x1,530,20,10);
    }
  }

  // �_���[�W���󂯂�
  public boolean damage(){
    if(shield_cnt>0) shield_cnt--;
    alive=(shield_cnt>0);
    return !alive;
  }

  // �d�Ȃ蔻��
  public boolean overlap(GameChar c){
    if(!alive || won) return false;
    return super.overlap(c);
  }

  // ����
  public void win(){
    won=true;
  }

  // �}�E�X���X�i�[
  public void mousePressed(MouseEvent ev){
    m_down=true; // �{�^����������Ă�����
  }
  public void mouseReleased(MouseEvent ev){
    m_down=false; // �{�^����������Ă��Ȃ����
  }
  public void mouseClicked(MouseEvent ev){}
  public void mouseEntered(MouseEvent ev){}
  public void mouseExited(MouseEvent ev){}
  public void mouseMoved(MouseEvent ev){
    mx=ev.getX(); // �}�E�X���W���X�V
    my=ev.getY();
  }
  public void mouseDragged(MouseEvent ev){
    mx=ev.getX(); // �}�E�X���W���X�V
    my=ev.getY();
  }
}
