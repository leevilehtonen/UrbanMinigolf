package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {

    protected double posX, posY;
    protected double velX, velY;
    protected Type type;
    protected Rectangle bounds;

    public GameObject(double posX, double posY, double width, double height, Type type) {

        this.bounds = new Rectangle((int) posX, (int) posY, (int) width, (int) height);
        this.type = type;
    }

    public abstract void update(double delta);

    public abstract void render(Graphics2D g);

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
        this.bounds.setLocation((int) Math.round(posX), this.bounds.y);
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
        this.bounds.setLocation(this.bounds.x, (int) Math.round(posY));
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void mirrorXVel() {
        this.velX = this.velX * (-1);
    }

    public void mirrorYVel() {
        this.velY = this.velY * (-1);
    }

}
