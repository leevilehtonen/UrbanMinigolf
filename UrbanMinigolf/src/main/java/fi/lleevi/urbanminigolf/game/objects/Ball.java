package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Graphics2D;

public class Ball extends GameObject {

    public Ball(int posX, int posY, Type type) {
        super(posX, posY, type);
    }

    @Override
    public void update(double delta) {
        posX += 100 * delta * velX;

        if (velX > 0) {
            velX -= 0.004;
        }

        if (Math.abs(velX) < 0.005) {
            velX = 0;
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.fillOval((int) posX, (int) posY, 20, 20);
    }

}
