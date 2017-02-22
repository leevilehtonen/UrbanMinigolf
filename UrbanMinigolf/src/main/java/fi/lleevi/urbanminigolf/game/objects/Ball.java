package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Pallo-objekti.
 * @author lleevi
 */
public class Ball extends MovableGameObject {

    /**
     * Pallon koko.
     */
    public static final int BALL_SIZE = 10;

    /**
     * Pallon "kitkakerroin" (kerrotaan nopeus jokaisessa päivityksessä).
     */
    public static final double BALL_FRICTION = 0.99; //16 fps = 0.975

    /**
     * Pallon pysähtymiskynnys nopeudessa/kitkassa.
     */
    public static final double BALL_FRICTION_THRESHOLD = 3;

    /**
     * Pallon lyöntiin lisättävä vakiokerroin.
     */
    public static final double BALL_HIT_MULTIPLIER = 2;

    private boolean hittable = true;
    private boolean inHole = false;

    /**
     * Luo uuden pallon paikkaan x,y.
     * 
     * @param posX pallon x koordinaatti
     * @param posY pallon y koordinaatti
     */
    public Ball(double posX, double posY) {
        super(posX, posY, BALL_SIZE, BALL_SIZE, Type.Ball);
    }

    /**
     * Päivitetään pallon sijaintia (siirretään paikkaa nopeuden peruteella ja vähennetään nopeutta).
     * 
     * @param delta päivitysten välinen aika
     */
    @Override
    public void update(double delta) {

        setPosX(getPosX() + delta * getVelX());
        setPosY(getPosY() + delta * getVelY());

        if (Math.abs(getVelX()) > BALL_FRICTION_THRESHOLD) {
            setVelX(getVelX() * BALL_FRICTION);
        } else {
            setVelX(0);
        }
        if (Math.abs(getVelY()) > BALL_FRICTION_THRESHOLD) {
            setVelY(getVelY() * BALL_FRICTION);
        } else {
            setVelY(0);
        }

        if (Math.abs(getVelX()) < BALL_FRICTION_THRESHOLD && Math.abs(getVelY()) < BALL_FRICTION_THRESHOLD) {
            hittable = true;
        }
    }

    /**
     * Pallon piirtäminen .
     * @param g Swing grafiikka olio
     */
    @Override
    public void render(Graphics2D g) {
        if (!inHole) {
            g.setColor(Color.WHITE);
            g.fillOval(getBounds().x, getBounds().y, BALL_SIZE, BALL_SIZE);
            g.setColor(Color.BLACK);
            g.drawOval(getBounds().x, getBounds().y, BALL_SIZE, BALL_SIZE);
        }
    }

    /**
     * Asetetaan palloon nopeus, kun sitä lyödään.
     * 
     * @param velX Pallon nopeus x suunnassa
     * @param velY Pallon nopeus y suunnassa
     */
    public void hit(double velX, double velY) {
        setVelX(velX * BALL_HIT_MULTIPLIER);
        setVelY(velY * BALL_HIT_MULTIPLIER);
    }

    /**
     * Tarkistetaan pallon osuma kaikkin objekteihin pelissä. (Seinistä pallo kimpoaa ja reijästä peli päättyy).
     * 
     * @param object Pelin objekti johon tarkistetaan osumaa
     */
    public void intersectsWith(GameObject object) {
        if (object.getType() == Type.Hole) {
            Hole hole = (Hole) object;
            if (hole.intersectsBall(this)) {
                inHole = true;
            }
        }
        if (object.getType() == Type.Wall) {
            Wall wall = (Wall) object;
            if (wall.hitBottom(this) || wall.hitTop(this)) {
                mirrorYVel();
            }
            if (wall.hitLeft(this) || wall.hitRight(this)) {
                mirrorXVel();
            }
        }
    }

    /**
     * Palautta onko pallo lyötävissä.
     * 
     * @return onko pallo lyötävissä
     */
    public boolean isHittable() {
        return hittable;
    }

    /**
     * Muuttaa pallon lyöntitilaa.
     * 
     * @param hittable voidaanko palloa lyödä
     */
    public void setHittable(boolean hittable) {
        this.hittable = hittable;
    }

    /**
     * Palauttaa onko pallo reijässä.
     * 
     * @return onko pallo reijässä
     */
    public boolean isInHole() {
        return inHole;
    }

    /**
     * Asettaa pallon reikään.
     * 
     * @param inHole onko pallo reijässä
     */
    public void setInHole(boolean inHole) {
        this.inHole = inHole;
    }

}
