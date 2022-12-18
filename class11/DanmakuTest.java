package class11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DanmakuTest extends JFrame {
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
        private ArrayList<Shot> shot_list;
        private long start_time;
        private double frame_count;

        public GameManager(GamePanel gp) {
            this.gp = gp;
            shot_list = new ArrayList<Shot>();
        }

        public void addShot(int n) {
            int w = gp.getWidth(), h = gp.getHeight();
            double x = w/2, y = h/2;
            for(int i = 0; i < n; i++) {
                double a = 2*Math.PI*Math.random();
                shot_list.add(new Shot(x, y, a));
            }
            gp.repaint();
        }

        public void delShot(int n) {
            int s = shot_list.size();
            for(int i = 0; i < n; i++) {
                if(s == 0) break;
                shot_list.remove(s-1);
                s = shot_list.size();
            }
            gp.repaint();
        }

        public void run() {
            start_time = System.nanoTime();
            frame_count = 0;
            while(true) {
                int w = gp.getWidth(), h = gp.getHeight();
                for(Shot s:shot_list) s.move(w, h);
                gp.repaint();
                try {
                    sleep(10);
                } catch (InterruptedException e) {}
                frame_count += 1;
            }
        }

        public void drawAllShots(Graphics g) {
            g.setColor(Color.white);
            for(Shot s:shot_list) s.draw(g);
            double t = (System.nanoTime()-start_time)/1000000000.0;
            double fps = (int) ((frame_count*10/t))/10;
            g.setColor(Color.cyan);
            g.setFont(new Font("", Font.PLAIN, 36));
            g.drawString("Shots:" + shot_list.size() + " FPS:" + fps, 10, 40);
            if(t > 2) {
                start_time = System.nanoTime();
                frame_count = 0;
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

    public DanmakuTest() {
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
        (new DanmakuTest()).setVisible(true);
    }

}