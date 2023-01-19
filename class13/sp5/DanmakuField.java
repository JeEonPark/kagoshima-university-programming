package class13.sp5;

import java.awt.*;
import javax.swing.*;

public class DanmakuField extends JPanel {
    private GameManager gm;

    public DanmakuField() {
        setBackground(Color.black);
    }

    public void setGM(GameManager gm) {
        this.gm = gm;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gm.draw(g);
    }
}
