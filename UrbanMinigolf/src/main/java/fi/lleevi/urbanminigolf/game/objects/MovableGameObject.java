package fi.lleevi.urbanminigolf.game.objects;

/**
 * Abstrakti tyyppi peliobjektista, joka liikkuu
 * @author lleevi
 */
public abstract class MovableGameObject extends GameObject implements Movable {

    protected double velX, velY;

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

    public void mirrorXVel() {
        this.velX = this.velX * (-1);
    }

    public void mirrorYVel() {
        this.velY = this.velY * (-1);
    }

}
