package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Color;
import java.awt.Graphics2D;

public class Wall extends GameObject {

    public static int SIZE = 40;

    public Wall(int posX, int posY) {
        super(posX, posY, SIZE,SIZE, Type.Wall);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.darkGray);
        g.fill(getBounds());
        g.setColor(Color.red);
    }

    public boolean hitTop(Ball ball) {
        return ball.getBounds().intersectsLine(getBounds().getX()+2, getBounds().getY(), getBounds().getMaxX()-2, getBounds().getY());
    }

    public boolean hitBottom(Ball ball) {
        return ball.getBounds().intersectsLine(getBounds().getX()+2, getBounds().getMaxY(), getBounds().getMaxX()-2, getBounds().getMaxY());
    }

    public boolean hitLeft(Ball ball) {
        return ball.getBounds().intersectsLine(getBounds().getX(), getBounds().getY()+2, getBounds().getX(), getBounds().getMaxY()-2);
    }

    public boolean hitRight(Ball ball) {
        return ball.getBounds().intersectsLine(getBounds().getMaxX(), getBounds().getY()+2, getBounds().getMaxX(), getBounds().getMaxY()-2);

    }

}
