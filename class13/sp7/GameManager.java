/***
 *** �Q�[���Ǘ���
 ***/
import java.awt.*;
import java.util.*;

public class GameManager extends Thread {
  private DanmakuField df;
  private Ship ship;
  private ArrayList<Beam> beams;
  private ArrayList<Enemy> enemies;
  private ArrayList<Bomb> bombs;
  private ArrayList<Explosion> explosions;
  private ArrayList<Shield> shields;
  private ArrayList<Msg> msgs;
  private int score;
  private Font score_font;
  private Stage stage;

  // ����
  public GameManager(DanmakuField df){
    this.df=df;
    beams=new ArrayList<Beam>(); // ��̃r�[�����X�g
    enemies=new ArrayList<Enemy>(); // ��̓G���X�g
    bombs=new ArrayList<Bomb>(); // ��̔��e���X�g
    explosions=new ArrayList<Explosion>(); // ��̔������X�g
    shields=new ArrayList<Shield>(); // ����̃V�[���h���X�g
    msgs=new ArrayList<Msg>(); // ���b�Z�[�W�̃��X�g
    stage=new StageDemo(this); // �ŏ��̃X�e�[�W
    score_font=new Font("",Font.PLAIN,24);
    initGame();
  }

  // ������
  public void initGame(){
    ship=new Ship(300,500);
    clearLists();
    df.addMouseListener(ship);
    df.addMouseMotionListener(ship);
    score=0;
  }
  
  // ���s
  public void run(){
    long t=0; // ����
    while(true){
      if(ship==null) continue; // �V�b�v���Ȃ��Ƃ��͉������Ȃ�
      int w=df.getWidth(),h=df.getHeight(); // ��ʂ̑傫��
      double sx=ship.getX(),sy=ship.getY(); // Ship�̈ʒu

      // �Q�[�����̃��m�̓���
      if(t%5==0) moveAllBeams(); // 5���1��r�[���ړ�
      if(t%10==0) ship.move(); // 10���1��V�b�v�ړ�
      if(t%30==0) ship.shot(this); // 30���1��r�[������
      if(t%20==0) moveAllEnemies(w,h,sx,sy); // 20���1��S�G�ړ�
      if(t%10==0) moveAllBombs(w,h); // 10���1��S���e�ړ�
      if(t%30==0) spreadAllExplosions(); // 30���1�񔚔����L����
      if(t%10==0) spreadAllShields(); // 10���1��V�[���h���L����
      if(t%5==0) collideBE(); // 5���1��r�[���ƓG�̏Փ˔���
      if(t%10==0) collideBS(); // 10���1�񔚒e��Ship�̏Փ˔���
      if(t%30==0) playAllMessages(); // 30���1�񃁃b�Z�[�W�𓮍�

      // �X�e�[�W�̐i�s
      if(t%200==0){
        if(!stage.proceed(w,h,sx,sy))
          stage=stage.next();
      }

      df.repaint();
      try{
        sleep(2);
      }catch(InterruptedException e){}
      t++;
    }
  }

  // �`��
  public void draw(Graphics g){
    int w=df.getWidth(),h=df.getHeight(); // ��ʂ̑傫��
    for(Beam b:beams) b.draw(g); // ���ׂẴr�[����`��
    for(Bomb b:bombs) b.draw(g); // ���ׂĂ̔��e��`��
    for(Enemy e:enemies) e.draw(g); // ���ׂĂ̓G��`��
    for(Explosion e:explosions) e.draw(g); // ���ׂĂ̔�����`��
    for(Shield s:shields) s.draw(g); // ���ׂẴV�[���h��`��
    ship.draw(g); // �V�b�v��`��
    stage.draw(g); // �X�e�[�W��`��
    for(Msg m:msgs) m.draw(g,w,h); // ���ׂẴ��b�Z�[�W��`��
    g.setFont(score_font);
    g.setColor(Color.white);
    g.drawString(""+score,10,30);
  }

  // �r�[���̒ǉ�
  public void addBeam(Beam b){
    beams.add(b);
  }

  // ���ׂẴr�[�����ړ�
  // ���݂��Ȃ��Ȃ����r�[���͍폜
  private void moveAllBeams(){
    Iterator<Beam> it=beams.iterator(); // �r�[����1�����o�������q
    while(it.hasNext()){ // ���̃r�[��������΁A
      Beam b=it.next(); // ��������o��
      if(!b.move()) // �ړ��̌��ʁAfalse���߂�Ή�ʊO�ɏo��
        it.remove(); // �̂Ń��X�g����폜
    }
  }

  // �G��ǉ�
  public void addEnemy(Enemy e){
    enemies.add(e);
  }

  // ���ׂĂ̓G���ړ�
  private void moveAllEnemies(int w,int h,double sx,double sy){
    Iterator<Enemy> it=enemies.iterator();
    while(it.hasNext()){
      Enemy e=it.next();
      e.dropBomb(sx,sy,this);
      if(!e.move(w,h,sx,sy))
        it.remove();
    }
  }

  // ���ׂĂ̔��e���ړ�
  private void moveAllBombs(int w,int h){
    Iterator<Bomb> it=bombs.iterator();
    while(it.hasNext()){
      Bomb b=it.next();
      if(!b.move(w,h))
        it.remove();
    }
  }

  // ���e��ǉ�����
  public void addBomb(Bomb b){
    bombs.add(b);
  }

  // ���ׂĂ̔����̍L����
  private void spreadAllExplosions(){
    Iterator<Explosion> it=explosions.iterator();
    while(it.hasNext()){
      Explosion e=it.next();
      if(!e.spread())
        it.remove();
    }
  }

  // ���ׂẴV�[���h���L����
  private void spreadAllShields(){
    Iterator<Shield> it=shields.iterator();
    while(it.hasNext()){
      Shield s=it.next();
      if(!s.spread())
        it.remove();
    }
  }

  // �r�[���ƓG�̏Փ˔���
  private void collideBE(){
    for(Beam b:beams){ // ���ׂẴr�[�������[�v
      for(Enemy e:enemies){ // ���ׂĂ̓G�����[�v
        if(b.overlap(e)){ // �����d�Ȃ��Ă�����
          score+=e.getScore(); // �_�������Z
          e.die(); // �G�͎���
          b.die(); // �r�[��������
          double x=e.getX(),y=e.getY(); // �G�̈ʒu��
          explosions.add(new Explosion(x,y)); // ������ǉ�
        }
      }
    }
  }

  // ���e��Ship�̏Փ˔���
  private void collideBS(){
    for(Bomb b:bombs){ // ���ׂĂ̔��e�����[�v
      if(ship.overlap(b)){ // ����Ship�Əd�Ȃ��Ă�����
        b.die(); // ���e�͎���
        double sx=ship.getX(),sy=ship.getY(); // Ship�̈ʒu��
        if(ship.damage()){ // Ship�ɂ̓_���[�W
          explosions.add(new ExplosionShip(sx,sy));
          stage=new StageOver(this);
        }
        else{
          shields.add(new Shield(sx,sy)); // �V�[���h��ǉ�
        }
      }
    }
  }

  // ���b�Z�[�W�̒ǉ�
  public void addMessage(Msg m){
    msgs.add(m);
  }

  // ���ׂẴ��b�Z�[�W�𓮍�
  private void playAllMessages(){
    Iterator<Msg> it=msgs.iterator();
    while(it.hasNext()){
      Msg m=it.next();
      if(!m.play()){
        it.remove();
      }
    }
  }

  // �e���t�B�[���h�𓾂�
  public DanmakuField getDF(){
    return df;
  }

  // �N���A
  // ���ׂẴ��X�g����ɂ���
  public void clearLists(){
    beams.clear();
    bombs.clear();
    enemies.clear();
    explosions.clear();
    shields.clear();
    msgs.clear();
  }

  // �Q�[���N���A
  public void gameClear(){
    ship.win(); // ����
    explosions.add(new ExplosionBoss());
    stage=new StageClear(this);
  }
}
