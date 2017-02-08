package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;

public class Ball extends MovableGameObject {

    public static final int BALL_SIZE = 10;
    public static final double BALL_FRICTION = 0.985;
    public static final double BALL_FRICTION_THRESHOLD = 3;
    public static final double BALL_HIT_MULTIPLIER = 2;

    private boolean hittable = true;
    private boolean inHole = false;

    public Ball(double posX, double posY) {
        super(posX, posY, BALL_SIZE, BALL_SIZE, Type.Ball);
    }

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

    @Override
    public void render(Graphics2D g) {
        if (!inHole) {
            g.setColor(Color.WHITE);
            g.fillOval(getBounds().x, getBounds().y, BALL_SIZE, BALL_SIZE);
            g.setColor(Color.BLACK);
            g.drawOval(getBounds().x, getBounds().y, BALL_SIZE, BALL_SIZE);
        }
    }

    public void hit(double velX, double velY) {
        setVelX(velX * BALL_HIT_MULTIPLIER);
        setVelY(velY * BALL_HIT_MULTIPLIER);
    }

    public void intersectsWith(GameObject object) {
        if (object.getType() == Type.Hole) {
            Hole hole = (Hole) object;
            if (hole.intersectsBall(this)) {
                inHole = true;
            }
        }
        if(object.getType() == Type.Wall) {
            Wall wall = (Wall) object;
            if(wall.hitBottom(this) || wall.hitTop(this)) {
                mirrorYVel();
            }
            if(wall.hitLeft(this) || wall.hitRight(this)) {
                mirrorXVel();
            }
        }
    }

    public boolean isHittable() {
        return hittable;
    }

    public void setHittable(boolean hittable) {
        this.hittable = hittable;
    }

    public boolean isInHole() {
        return inHole;
    }

    public void setInHole(boolean inHole) {
        this.inHole = inHole;
    }

}
