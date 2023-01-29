
/***
 *** The Danmaku
 ***/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// TheDanmakuクラス
public class TheDanmaku extends JFrame {

  public TheDanmaku() {
    super("The Danmaku");
    setSize(600, 600);
    setLocation(300, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    DanmakuField df = new DanmakuField();
    GameManager gm = new GameManager(df);
    df.setGM(gm);
    add(df);
    setVisible(true);
    gm.start(); // ゲーム管理者を開始する
  }

  // メイン
  public static void main(String[] args) {
    new TheDanmaku();
  }
}
