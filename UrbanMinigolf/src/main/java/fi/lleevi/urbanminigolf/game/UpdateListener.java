package fi.lleevi.urbanminigolf.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Päivityskuuntelija, update timerin kutsuma.
 * @author lleevi
 */
public class UpdateListener implements ActionListener {

    private final GameEngine engine;

    private long lastTime, currentTime;
    /**
     * Update listener.
     * 
     * @param engine käytettävä pelimoottori.
     */
    public UpdateListener(GameEngine engine) {
        this.engine = engine;
        this.lastTime = System.nanoTime();
    }
    /**
     * Tapahtuma, joka kutsutaan kun halutaan päivittää peliä (timerilla).
     * 
     * @param e tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        currentTime = System.nanoTime();
        double delta = (currentTime - lastTime) * 1.0 / 1000000000;
        engine.update(delta);
        lastTime = currentTime;
    }

}
