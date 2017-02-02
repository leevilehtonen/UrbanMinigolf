package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Graphics2D;

public class Ball extends GameObject {

    public Ball(int posX, int posY, Type type) {
        super(posX, posY, 20, 20, type);
    }

    @Override
    public void update(double delta) {
        setLocation((int) Math.round(getX() + ((getVelX() * 100) * delta)), (int) getY());

        if (getVelX() > 0.0f) {
            setVelX((float) (getVelX() - 0.02));
        } else {
            setVelX((float) (getVelX() + 0.02));
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.fillOval((int) getX(), (int) getY(), 20, 20);
    }

    public void instersect(GameObject object) {
        Wall wall = (Wall) object;

        if (intersectsLine(wall.getX(), wall.getY(), wall.getX(), wall.getMaxY())) {
            mirrorXVel();
        }

    }

}
