package fi.lleevi.urbanminigolf.game.objects;

import fi.lleevi.urbanminigolf.game.objects.Type;

/**
 * Abstrakti tyyppi peliobjektista, joka liikkuu.
 * @author lleevi
 */
public abstract class MovableGameObject extends GameObject implements Movable {

    protected double velX, velY;
    
    /**
     * Luo uuden liikkuvan peliobjektin.
     * 
     * @param posX x koordinaatti
     * @param posY y koordinaatti
     * @param width leveys
     * @param height korkeus
     * @param type tyyppi
     */
    public MovableGameObject(double posX, double posY, double width, double height, Type type) {
        super(posX, posY, width, height, type);
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }
    /**
     * Peilaa x nopeuden.
     */
    public void mirrorXVel() {
        this.velX = this.velX * (-1);
    }
    /**
     * Peilaa y nopeuden.
     */
    public void mirrorYVel() {
        this.velY = this.velY * (-1);
    }

}
