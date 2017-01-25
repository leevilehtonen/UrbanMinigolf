package fi.lleevi.urbanminigolf.game.objects;

import fi.lleevi.urbanminigolf.game.objects.Type;
import java.awt.Graphics2D;


public abstract class GameObject {
    
    protected float posX, posY;
    protected float velX, velY;
    protected Type type;

    public GameObject(float posX, float posY, Type type) {
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }
    public abstract void update(double delta);
    public abstract void render(Graphics2D g);

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

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
    
    
    
}
