package class9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TextDisplay extends JFrame {
    class ControlPanel extends JPanel implements ActionListener {
        private JTextField tf_str;
        private JTextField tf_number_str;
        private DisplayPanel disp;

        public ControlPanel() {
            tf_str = new JTextField(20);
            tf_number_str = new JTextField(10);
            JButton bt = new JButton("追加");
            bt.addActionListener(this);
            add(tf_str);
            add(bt);
        }

        public void setDisplayPanel(DisplayPanel dp) {
            disp = dp;
        }

        public void actionPerformed(ActionEvent ev) {
            String s = tf_str.getText();
            disp.addStr(s);
        }
    }

    class DisplayPanel extends JPanel {
        private ArrayList<String> str_list;

        public DisplayPanel() {
            str_list = new ArrayList<String>();
            setBackground(Color.white);
        }

        public void addStr(String s) {
            str_list.add(s);
            repaint();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth(), h = getHeight();
            for(String s:str_list) {
                int x = (int) (Math.random()*w);
                int y = (int) (Math.random()*h);
                g.setColor(new Color((int) (Math.random()*0xFFFFFF)));
                g.drawString(s, x, y);
            }
        }
    }

    public TextDisplay() {
        super("文字列の表示");
        setSize(600, 500);
        setLocation(200, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DisplayPanel dp = new DisplayPanel();
        add(dp, BorderLayout.CENTER);

        ControlPanel cp = new ControlPanel();
        cp.setDisplayPanel(dp);
        add(cp, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        (new TextDisplay()).setVisible(true);
    }
}
