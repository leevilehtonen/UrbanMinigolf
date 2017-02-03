package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Graphics2D;

public class Ball extends GameObject {

    public static final int BALL_SIZE = 10;
    public static final double BALL_FRICTION = 0.98;
    public static final double BALL_FRICTION_THRESHOLD = 3;

    public Ball(double posX, double posY, Type type) {
        super(posX, posY, BALL_SIZE, BALL_SIZE, type);
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
    }

    @Override
    public void render(Graphics2D g) {
        g.fillOval(getBounds().x, getBounds().y, 10, 10);
    }

    public void hit(double velX, double velY) {
        setVelX(velX);
        setVelY(velY);
    }
}
