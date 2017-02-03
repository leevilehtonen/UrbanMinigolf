package fi.lleevi.urbanminigolf.game;

import fi.lleevi.urbanminigolf.game.objects.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class MouseListener implements MouseInputListener {

    private final GameEngine engine;
    private final Cursor cursor;

    public MouseListener(GameEngine engine, Cursor cursor) {
        this.engine = engine;
        this.cursor = cursor;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursor.setLocation(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.cursor.setCanDraw(false);
        this.engine.hitBall(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
