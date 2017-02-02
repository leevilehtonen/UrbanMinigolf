package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject extends Rectangle {

    protected float velX, velY;
    protected Type type;

    public GameObject(float posX, float posY, float width, float height, Type type) {
        super((int) posX, (int) posY, (int) width, (int) height);
        this.type = type;
    }

    public abstract void update(double delta);

    public abstract void render(Graphics2D g);

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
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
