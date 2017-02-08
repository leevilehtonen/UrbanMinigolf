package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Color;
import java.awt.Graphics2D;

public class Hole extends GameObject {

    public static final int HOLE_SIZE = 20;

    public Hole(double posX, double posY) {
        super(posX, posY, HOLE_SIZE, HOLE_SIZE, Type.Hole);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillOval((int) Math.round(getPosX()), (int) Math.round(getPosY()), HOLE_SIZE, HOLE_SIZE);
        g.setColor(Color.BLACK);
        g.drawOval((int) Math.round(getPosX()), (int) Math.round(getPosY()), HOLE_SIZE, HOLE_SIZE);
    }

    public boolean intersectsBall(Ball ball) {
        return getBounds().intersects(ball.getBounds());
//        return ((Math.abs(getBounds().getCenterX() - ball.getBounds().getCenterX())) < Ball.BALL_SIZE + Hole.HOLE_SIZE) && 
 //               ((Math.abs(getBounds().getCenterY() - ball.getBounds().getCenterY()) < Ball.BALL_SIZE + Hole.HOLE_SIZE));

   
    }

}
