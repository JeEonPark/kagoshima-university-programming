/***
 *** デモステージ
 ***/
import java.awt.*;
import java.awt.event.*;

public class StageDemo extends Stage implements KeyListener {
  private boolean start;
  
  // 生成
  public StageDemo(GameManager gm){
    super(gm);
    start=false;
    gm.getDF().addKeyListener(this);
  }

  // 進行
  public boolean proceed(int w,int h,double sx,double sy){
    if(lap==0){ // 最初だけ点滅メッセージを追加する
      gm.addMessage(new MsgBrink("T h e   D A N M A K U",200,Color.orange,32));
      gm.addMessage(new MsgBrink("Press S key to Start!",350,Color.white,24));
    }
    lap++;
    return !start;
  }

  // 次のステージ
  public Stage next(){
    return new Stage1(gm);
  }

  // キーリスナー
  public void keyPressed(KeyEvent ev){
    if(ev.getKeyCode()==KeyEvent.VK_S){
      gm.initGame();
      start=true;
    }
  }
  public void keyReleased(KeyEvent ev){}
  public void keyTyped(KeyEvent ev){}
}
