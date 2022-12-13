package class10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DanmakuTest3 extends JFrame {
    public class Shot {
        private double sx, sy;
        private double vx, vy;

        public Shot(double x, double y, double a) {
            sx = x;
            sy = y;
            vx = 3*Math.cos(a);
            vy = 3*Math.sin(a);
        }

        public void move(int w, int h) {
            sx += vx;
            sy += vy;
            if(sx < 0 || sx > w) vx=-vx;
            if(sy < 0 || sy > h) vy=-vy;
        }

        public void draw(Graphics g) {
            g.drawOval((int)sx-3, (int)sy-3, 6, 6);
        }
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
        private Shot shot;

        public GameManager(GamePanel gp) {
            this.gp = gp;
            shot = null;
        }

        public void addShot(int n) {
            int w = gp.getWidth(), h = gp.getHeight();
            double x = w/2, y = h/2;
            double a = 2*Math.PI*Math.random();
            shot = new Shot(x, y, a);
            gp.repaint();
        }

        public void delShot(int n) {
            shot = null;
            gp.repaint();
        }

        public void run() {
            while(true) {
                int w = gp.getWidth(), h = gp.getHeight();
                if(shot != null) {
                    shot.move(w,h);
                }
                gp.repaint();
                try {
                    sleep(10);
                } catch (InterruptedException e) {}
            }
        }

        public void drawAllShots(Graphics g) {
            g.setColor(Color.white);
            if(shot != null) {
                shot.draw(g);
            }
        }
    }

    public class GamePanel extends JPanel {
        private GameManager gm;

        public GamePanel() {
            setBackground(Color.black);
        }

        public void setGameManager(GameManager gm) {
            this.gm = gm;
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            gm.drawAllShots(g);
        }
    }

    public DanmakuTest3() {
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
        (new DanmakuTest3()).setVisible(true);
    }

}