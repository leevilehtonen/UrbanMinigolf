package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Seinä objekti
 * @author lleevi
 */
public class Wall extends GameObject {
    
    /**
     * Seinän koko
     */
    public static final int WALL_SIZE = 40;

    public Wall(int posX, int posY) {
        super(posX, posY, WALL_SIZE, WALL_SIZE, Type.Wall);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.darkGray);
        g.fill(getBounds());
        g.setColor(Color.red);
    }

    /**
     * Tarkistetaan pallon osuma seinän yläreunaan
     *
     * @param ball verrattava pallo
     *
     * @return osuuko pallo seinän yläreunaan
     */
    public boolean hitTop(Ball ball) {
        return ball.getBounds().intersectsLine(getBounds().getX() + 2, getBounds().getY(), getBounds().getMaxX() - 2, getBounds().getY());
    }

    /**
     * Tarkistetaan pallon osuma seinän alareunaan
     *
     * @param ball verrattava pallo
     *
     * @return osuuko pallo seinän alareunaan
     */
    public boolean hitBottom(Ball ball) {
        return ball.getBounds().intersectsLine(getBounds().getX() + 2, getBounds().getMaxY(), getBounds().getMaxX() - 2, getBounds().getMaxY());
    }

    /**
     * Tarkistetaan pallon osuma seinän vasempaan reunaan
     *
     * @param ball verrattava pallo
     *
     * @return osuuko pallo seinän vasempaan reunaan
     */
    public boolean hitLeft(Ball ball) {
        return ball.getBounds().intersectsLine(getBounds().getX(), getBounds().getY() + 2, getBounds().getX(), getBounds().getMaxY() - 2);
    }

    /**
     * Tarkistetaan pallon osuma seinän oikeaan reunaan
     *
     * @param ball verrattava pallo
     *
     * @return osuuko pallo seinän oikeaan reunaan
     */
    public boolean hitRight(Ball ball) {
        return ball.getBounds().intersectsLine(getBounds().getMaxX(), getBounds().getY() + 2, getBounds().getMaxX(), getBounds().getMaxY() - 2);

    }

}
