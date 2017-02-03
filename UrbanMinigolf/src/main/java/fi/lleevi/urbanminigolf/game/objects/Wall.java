package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Graphics2D;

public class Wall extends GameObject {

    public Wall(int posX, int posY, Type type) {
        super(posX, posY, 100, 100, type);
    }

    @Override
    public void update(double delta) {
    }

    @Override
    public void render(Graphics2D g) {
        g.fill(getBounds());
    }

}
