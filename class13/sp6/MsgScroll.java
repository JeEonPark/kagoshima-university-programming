package class13.sp6;

import java.awt.*;

public class MsgScroll extends Msg {
    private String msg;
    Font font;
    private Color col;
    private int freeze;

    public MsgScroll(String m, Color c, int s) {

        this(m, c, s, 50, 20);
    }

    public MsgScroll(String m, Color c, int s, int l, int f) {
        msg = m;
        col = c;
        font = new Font("", Font.PLAIN, s);
        age = 0;
        life = 1;
        freeze = f;
    }

    public void draw(Graphics g, int w, int h) {
        g.setFont(font);
        g.setColor(col);
        int sh = g.getFontMetrics().getHeight();
        int a = age;
        if (a > (life - freeze) / 2) {
            if (a > (life + freeze) / 2) {
                a = age - freeze;
            } else {
                a = (life - freeze) / 2;

            }
        }
        int y = h - a * (h + sh) / (life - freeze);
        drawCenter(g, msg, w, y);
    }
}
