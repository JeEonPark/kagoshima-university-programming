/***
 *** ゲーム管理者
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

  // 生成
  public GameManager(DanmakuField df){
    this.df=df;
    beams=new ArrayList<Beam>(); // 空のビームリスト
    enemies=new ArrayList<Enemy>(); // 空の敵リスト
    bombs=new ArrayList<Bomb>(); // 空の爆弾リスト
    explosions=new ArrayList<Explosion>(); // 空の爆発リスト
    shields=new ArrayList<Shield>(); // からのシールドリスト
    msgs=new ArrayList<Msg>(); // メッセージのリスト
    stage=new StageDemo(this); // 最初のステージ
    score_font=new Font("",Font.PLAIN,24);
    initGame();
  }

  // 初期化
  public void initGame(){
    ship=new Ship(300,500);
    clearLists();
    df.addMouseListener(ship);
    df.addMouseMotionListener(ship);
    score=0;
  }
  
  // 実行
  public void run(){
    long t=0; // 時間
    while(true){
      if(ship==null) continue; // シップがないときは何もしない
      int w=df.getWidth(),h=df.getHeight(); // 画面の大きさ
      double sx=ship.getX(),sy=ship.getY(); // Shipの位置

      // ゲーム内のモノの動き
      if(t%5==0) moveAllBeams(); // 5回に1回ビーム移動
      if(t%10==0) ship.move(); // 10回に1回シップ移動
      if(t%30==0) ship.shot(this); // 30回に1回ビーム発射
      if(t%20==0) moveAllEnemies(w,h,sx,sy); // 20回に1回全敵移動
      if(t%10==0) moveAllBombs(w,h); // 10回に1回全爆弾移動
      if(t%30==0) spreadAllExplosions(); // 30回に1回爆発を広げる
      if(t%10==0) spreadAllShields(); // 10回に1回シールドを広げる
      if(t%5==0) collideBE(); // 5回に1回ビームと敵の衝突判定
      if(t%10==0) collideBS(); // 10回に1回爆弾とShipの衝突判定
      if(t%30==0) playAllMessages(); // 30回に1回メッセージを動作

      // ステージの進行
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

  // 描画
  public void draw(Graphics g){
    int w=df.getWidth(),h=df.getHeight(); // 画面の大きさ
    for(Beam b:beams) b.draw(g); // すべてのビームを描画
    for(Bomb b:bombs) b.draw(g); // すべての爆弾を描画
    for(Enemy e:enemies) e.draw(g); // すべての敵を描画
    for(Explosion e:explosions) e.draw(g); // すべての爆発を描画
    for(Shield s:shields) s.draw(g); // すべてのシールドを描画
    ship.draw(g); // シップを描画
    stage.draw(g); // ステージを描画
    for(Msg m:msgs) m.draw(g,w,h); // すべてのメッセージを描画
    g.setFont(score_font);
    g.setColor(Color.white);
    g.drawString(""+score,10,30);
  }

  // ビームの追加
  public void addBeam(Beam b){
    beams.add(b);
  }

  // すべてのビームを移動
  // 存在しなくなったビームは削除
  private void moveAllBeams(){
    Iterator<Beam> it=beams.iterator(); // ビームを1つずつ取り出す反復子
    while(it.hasNext()){ // 次のビームがあれば、
      Beam b=it.next(); // それを取り出す
      if(!b.move()) // 移動の結果、falseが戻れば画面外に出た
        it.remove(); // のでリストから削除
    }
  }

  // 敵を追加
  public void addEnemy(Enemy e){
    enemies.add(e);
  }

  // すべての敵を移動
  private void moveAllEnemies(int w,int h,double sx,double sy){
    Iterator<Enemy> it=enemies.iterator();
    while(it.hasNext()){
      Enemy e=it.next();
      e.dropBomb(sx,sy,this);
      if(!e.move(w,h,sx,sy))
        it.remove();
    }
  }

  // すべての爆弾を移動
  private void moveAllBombs(int w,int h){
    Iterator<Bomb> it=bombs.iterator();
    while(it.hasNext()){
      Bomb b=it.next();
      if(!b.move(w,h))
        it.remove();
    }
  }

  // 爆弾を追加する
  public void addBomb(Bomb b){
    bombs.add(b);
  }

  // すべての爆発の広げる
  private void spreadAllExplosions(){
    Iterator<Explosion> it=explosions.iterator();
    while(it.hasNext()){
      Explosion e=it.next();
      if(!e.spread())
        it.remove();
    }
  }

  // すべてのシールドを広げる
  private void spreadAllShields(){
    Iterator<Shield> it=shields.iterator();
    while(it.hasNext()){
      Shield s=it.next();
      if(!s.spread())
        it.remove();
    }
  }

  // ビームと敵の衝突判定
  private void collideBE(){
    for(Beam b:beams){ // すべてのビームをループ
      for(Enemy e:enemies){ // すべての敵をループ
        if(b.overlap(e)){ // もし重なっていたら
          score+=e.getScore(); // 点数を加算
          e.die(); // 敵は死ぬ
          b.die(); // ビームも死ぬ
          double x=e.getX(),y=e.getY(); // 敵の位置に
          explosions.add(new Explosion(x,y)); // 爆発を追加
        }
      }
    }
  }

  // 爆弾とShipの衝突判定
  private void collideBS(){
    for(Bomb b:bombs){ // すべての爆弾をループ
      if(ship.overlap(b)){ // もしShipと重なっていたら
        b.die(); // 爆弾は死ぬ
        double sx=ship.getX(),sy=ship.getY(); // Shipの位置に
        if(ship.damage()){ // Shipにはダメージ
          explosions.add(new ExplosionShip(sx,sy));
          stage=new StageOver(this);
        }
        else{
          shields.add(new Shield(sx,sy)); // シールドを追加
        }
      }
    }
  }

  // メッセージの追加
  public void addMessage(Msg m){
    msgs.add(m);
  }

  // すべてのメッセージを動作
  private void playAllMessages(){
    Iterator<Msg> it=msgs.iterator();
    while(it.hasNext()){
      Msg m=it.next();
      if(!m.play()){
        it.remove();
      }
    }
  }

  // 弾幕フィールドを得る
  public DanmakuField getDF(){
    return df;
  }

  // クリア
  // すべてのリストを空にする
  public void clearLists(){
    beams.clear();
    bombs.clear();
    enemies.clear();
    explosions.clear();
    shields.clear();
    msgs.clear();
  }

  // ゲームクリア
  public void gameClear(){
    ship.win(); // 勝つ
    explosions.add(new ExplosionBoss());
    stage=new StageClear(this);
  }
}
