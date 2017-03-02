package fi.lleevi.urbanminigolf.listeners;

import fi.lleevi.urbanminigolf.game.GameEngine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Törmäyskuuntelija, collision timerin kutsuma.
 *
 * @author lleevi
 */
public class CollisionListener implements ActionListener {

    private GameEngine engine;

    /**
     * Törmäyskuuntelija.
     *
     * @param engine käytettävä pelimoottori.
     */
    public CollisionListener(GameEngine engine) {
        this.engine = engine;
    }

    /**
     * Tapahtuma, joka kutsutaan kun halutaan tarkistaa osumat timerilla.
     *
     * @param e tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        engine.checkCollision();
    }

}
