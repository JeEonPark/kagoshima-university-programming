package class10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DanmakuTest1 extends JFrame {
    public class Shot {
    }

    public class ControlPanel extends JPanel implements ActionListener {
        private JTextField tf_num;
        private GameManager gm;

        public ControlPanel(GameManager gm) {
            this.gm = gm;
            tf_num = new JTextField("1", 5);
            add(tf_num);
            JButton bt = new JButton("追加");
            bt.addActionListener(this);
            add(bt);
            bt = new JButton("削除");
            bt.addActionListener(this);
            add(bt);
        }

        public void actionPerformed(ActionEvent ev) {}
    }

    public class GameManager extends Thread {
        public GameManager(GamePanel gp) {
        }
    }

    public class GamePanel extends JPanel {
        public GamePanel() {
            setBackground(Color.black);
        }

        public void setGameManager(GameManager gm) {}
    }

    public DanmakuTest1() {
        super("弾幕テスト");
        setSize(600, 600);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gp = new GamePanel();
        GameManager gm = new GameManager(gp);
        ControlPanel cp = new ControlPanel(gm);
        gp.setGameManager(gm);
        add(gp, BorderLayout.CENTER);
        add(cp, BorderLayout.NORTH);
        gm.start();
    }

    public static void main(String[] args) {
        (new DanmakuTest1()).setVisible(true);
    }

}