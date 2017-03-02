package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Reikä objekti.
 * @author lleevi
 */
public class Hole extends GameObject {

    /**
     * Reijän koko.
     */
    public static final int HOLE_SIZE = 15;
    
    /**
     * Luo uuden reijän.
     * 
     * @param posX x koordinaatti
     * @param posY y koordinaatti
     */
    public Hole(double posX, double posY) {
        super(posX, posY, HOLE_SIZE, HOLE_SIZE, Type.Hole);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillOval((int) Math.round(getPosX()), (int) Math.round(getPosY()), HOLE_SIZE, HOLE_SIZE);
        g.setColor(Color.BLACK);
        g.drawOval((int) Math.round(getPosX()), (int) Math.round(getPosY()), HOLE_SIZE, HOLE_SIZE);
    }
    /**
     * Tarkistetaan pallon osuma reikään.
     * 
     * @param ball verrattava pallo
     * 
     * @return osuuko pallo reikään
     */
    public boolean intersectsBall(Ball ball) {
        return getBounds().intersects(ball.getBounds());
    }

}
