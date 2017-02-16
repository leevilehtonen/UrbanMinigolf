package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Peliobjektin abstrakti perusluokka.
 *
 * @author lleevi
 */
public abstract class GameObject {

    protected double posX, posY;
    protected Type type;
    protected Rectangle bounds;

    /**
     * Abstarkti peli objekti.
     *
     * @param posX x koordinaatti
     * @param posY y koordinaatti
     * @param width leveys
     * @param height korkeus
     * @param type tyyppi
     */
    public GameObject(double posX, double posY, double width, double height, Type type) {
        this.posX = posX;
        this.posY = posY;
        this.bounds = new Rectangle((int) posX, (int) posY, (int) width, (int) height);
        this.type = type;
    }

    /**
     * Renderöi objektin.
     *
     * @param g swing grafiikka
     */
    public abstract void render(Graphics2D g);

    public double getPosX() {
        return posX;
    }

    /**
     * Asettaa x koordinaatin.
     * 
     * @param posX x koordinaatti.
     */
    public void setPosX(double posX) {
        this.posX = posX;
        this.bounds.setLocation((int) Math.round(posX), this.bounds.y);
    }

    public double getPosY() {
        return posY;
    }

    /**
     * Asettaa y koordinaatin.
     *
     * @param posY y koordinaati.
     */
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
