package fi.lleevi.urbanminigolf.game;

import fi.lleevi.urbanminigolf.game.objects.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 * Hiirikuuntelija
 * @author lleevi
 */
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

    /**
     * Päivitetään suuntavektoria hiiren suuntaan
     * 
     * @param e painallustapahtuma
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        cursor.setLocation(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    
    /**
     * Hiirtä painettaessa laukaistaan pallo hiiren suuntaan
     * 
     * @param e painallustapahtuma
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (this.engine.isHittable()) {
            this.engine.hitBall(e.getX(), e.getY());
            this.engine.setHittable(false);
        }
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
