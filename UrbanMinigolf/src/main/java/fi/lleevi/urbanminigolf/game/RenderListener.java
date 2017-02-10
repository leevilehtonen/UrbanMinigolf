package fi.lleevi.urbanminigolf.game;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Piirtokuuntelija, render listenerin kutsuma
 * @author lleevi
 */
public class RenderListener implements ActionListener {

    private final GameEngine engine;

    public RenderListener(GameEngine engine) {
        this.engine = engine;
    }
    /**
     * Tapahtuma, joka kutsutaan kun halutaan piirtää (timerilla)
     * 
     * @param e tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        engine.paintImmediately(0, 0, engine.getWidth(), engine.getHeight());
        Toolkit.getDefaultToolkit().sync();
    }

}
