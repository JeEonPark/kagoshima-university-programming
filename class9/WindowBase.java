package class9;

import java.awt.*;
import javax.swing.*;

public class WindowBase extends JFrame {
    public WindowBase() {
        super("General Window");
        setSize(600, 500);
        setLocation(200, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.add(new JTextField(20));
        p1.add(new JButton("追加"));
        add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        add(p2, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        (new WindowBase()).setVisible(true);
    }
}
