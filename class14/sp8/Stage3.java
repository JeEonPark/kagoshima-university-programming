import java.awt.*;

public class Stage3 extends Stage {

  // 生成
  public Stage3(GameManager gm){
    super(gm);
  }
  
  // 進行
  // Stage3はBossを倒すまで終わらない
  public boolean proceed(int w,int h,double sx,double sy){
    if(lap==0)
      gm.addMessage(new MsgScroll("Final Stage",Color.yellow,32));
    if(lap>15 && lap%4==0)
      gm.addEnemy(new Enemy1(w,h));
    if(lap>20 && lap%2==0)
      gm.addEnemy(new Enemy2(w,h,sx,sy));
    if(lap>30 && lap%3==0)
      gm.addEnemy(new Enemy3(w,h,sx,sy));
    if(lap==50)
      gm.addMessage(new MsgScroll("Warning!!",Color.red,48));
    if(lap==60)
      gm.addEnemy(new EnemyBoss(w,h));
    lap++;
    return true;
  }

  // 次のステージはない
  public Stage next(){
    return null;
  }
}
