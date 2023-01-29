
/***
 *** The Danmaku
 ***/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// TheDanmaku�N���X
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
    gm.start(); // �Q�[���Ǘ��҂��J�n����
  }

  // ���C��
  public static void main(String[] args) {
    new TheDanmaku();
  }
}
