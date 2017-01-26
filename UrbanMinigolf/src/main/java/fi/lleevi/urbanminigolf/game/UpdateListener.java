/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lleevi.urbanminigolf.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lleevi
 */
public class UpdateListener implements ActionListener {

    private final GameEngine engine;

    private long lastTime, currentTime;

    public UpdateListener(GameEngine engine) {
        this.engine = engine;
        this.lastTime = System.nanoTime();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentTime = System.nanoTime();
        double delta = (currentTime - lastTime) * 1.0 / 1000000000;
        engine.update(delta);
        lastTime = currentTime;
    }

}
