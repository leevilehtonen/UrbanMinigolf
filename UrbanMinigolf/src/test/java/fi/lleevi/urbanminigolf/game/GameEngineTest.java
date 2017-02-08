/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lleevi.urbanminigolf.game;

import fi.lleevi.urbanminigolf.game.objects.Ball;
import fi.lleevi.urbanminigolf.game.objects.Type;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lleevi
 */
public class GameEngineTest {

    private GameEngine engine;

    public GameEngineTest() {

    }

    @Before
    public void setUp() {
        engine = new GameEngine();
    }

    @Test
    public void gameEngineInitializeTest() {
        assertTrue(engine.isRunning());
    }

    @Test
    public void gameEngineItemsAddedTest() {
        int sizeInit = engine.getObjects().size();
        engine.addNewGameObject(new Ball(0, 0));
        assertTrue(engine.getObjects().size() == sizeInit + 1);
    }

    @Test
    public void gameEngineItemsRemovedTest() {
        int sizeInit = engine.getObjects().size();
        Ball b = new Ball(0, 0);
        engine.addNewGameObject(b);
        assertTrue(engine.getObjects().size() == sizeInit + 1);
        engine.removeGameObject(b);
        assertTrue(engine.getObjects().size() == sizeInit);

    }

    @Test
    public void engineCanBeStopped() {
        assertTrue(engine.isRunning());
        engine.setRunning(false);
        assertTrue(!engine.isRunning());
    }

    @Test
    public void engineUpdatesObjectsIfNotHit() {
        double posInit = engine.getObjects().get(0).getPosX();
        engine.update(1);
        System.out.println(posInit);
        assertTrue(posInit == 0);
    }

    @Test
    public void engineUpdatesObjectsIfHit() {
        double posInit = engine.getObjects().get(0).getPosX();
        ((Ball) engine.getObjects().get(0)).hit(100, 100);
        engine.update(1);
        System.out.println(posInit);
        assertTrue(posInit != engine.getObjects().get(0).getPosX());
    }

    @Test
    public void engineUpdatesObjectsIfHitWithoutSpeed() {
        double posInit = engine.getObjects().get(0).getPosX();
        ((Ball) engine.getObjects().get(0)).hit(0, 0);
        engine.update(1);
        System.out.println(posInit);
        assertTrue(posInit == 0);
    }
    @Test
    public void hittingChangesSpeed() {
        Ball b = (Ball) engine.getObjects().get(0);
        double initSpeedX = b.getVelX();
        double initSpeedY = b.getVelY();
        engine.hitBall(100, 100);
        assertTrue(initSpeedX!=b.getVelX());
        assertTrue(initSpeedY!=b.getVelY());
    }
    @Test
    public void hittingWithZeroNotChangeSpeed() {
        Ball b = (Ball) engine.getObjects().get(0);
        double initSpeedX = b.getVelX();
        double initSpeedY = b.getVelY();
        engine.hitBall(b.getBounds().getCenterX(), b.getBounds().getCenterY());
        assertTrue(initSpeedX==b.getVelX());
        assertTrue(initSpeedY==b.getVelY());
    }
    
    

}
