package class13.sp6;

import java.awt.*;

public abstract class Msg {
    protected int age;
    protected int life;
    protected boolean alive;

    public Msg() {
        life = 0;
        alive = true;
    }

    public abstract void draw(Graphics g, int w, int h);

    public boolean play() {
        age++;
        if (life > 0)
            alive = (age < life);
        return alive;
    }

    public void die() {
        alive = false;
    }

    protected void drawCenter(Graphics g, String s, int w, int y) {
        FontMetrics fm = g.getFontMetrics();
        int sw = fm.stringWidth(s);
        int sh = fm.getHeight();
        int x = (w - sw) / 2;
        y += sh / 2;
        g.drawString(s, x, y);
    }

}