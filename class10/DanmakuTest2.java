package class10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DanmakuTest2 extends JFrame {
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

        public void actionPerformed(ActionEvent ev) {
            try {
                String cmd = ev.getActionCommand();
                int n = Integer.parseInt(tf_num.getText());
                switch(cmd) {
                    case "追加": gm.addShot(n); break;
                    case "削除": gm.delShot(n); break;
                }
            } catch(NumberFormatException e) {
                System.err.println(e);
            }
        }
    }

    public class GameManager extends Thread {
        private GamePanel gp;

        public GameManager(GamePanel gp) {
            this.gp = gp;
        }

        public void addShot(int n) {
            System.out.println(n + " Shots added");
        }

        public void delShot(int n) {
            System.out.println(n + " Shots deleted");
        }

        public void run() {
            while(true) {
                System.out.println("GameManager looping...");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
    }

    public class GamePanel extends JPanel {
        public GamePanel() {
            setBackground(Color.black);
        }

        public void setGameManager(GameManager gm) {}
    }

    public DanmakuTest2() {
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
        (new DanmakuTest2()).setVisible(true);
    }

}