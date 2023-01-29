import java.awt.*;

public class MsgBrink extends Msg {
    private String msg;
    private Color col;
    private Font font;
    private int py;
    private int on, off;

    public MsgBrink(String m, int y, Color c, int s) {

        this(m, y, c, s, 10, 5, 0);
    }

    public MsgBrink(String m, int y, Color c, int s, int on, int off, int l) {
        msg = m;
        py = y;
        col = c;
        font = new Font("", Font.PLAIN, s);
        this.on = on;
        this.off = off;
        life = l;
        age = 0;
    }

    public void draw(Graphics g, int w, int h) {
        if (age % (on + off) < on) {
            g.setColor(col);
            g.setFont(font);
            drawCenter(g, msg, w, py);
        }
    }

}