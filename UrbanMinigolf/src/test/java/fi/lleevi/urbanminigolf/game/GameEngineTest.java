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
        assertTrue(engine.getObjects().size() == 1);
        engine.addNewGameObject(new Ball(0, 0, Type.Ball));
        assertTrue(engine.getObjects().size() == 2);
    }

    @Test
    public void gameEngineItemsRemovedTest() {
        assertTrue(engine.getObjects().size() == 1);
        Ball b = new Ball(0, 0, Type.Ball);
        engine.addNewGameObject(b);
        assertTrue(engine.getObjects().size() == 2);
        engine.removeGameObject(b);
        assertTrue(engine.getObjects().size() == 1);   
        
    }

    @Test
    public void engineCanBeStopped() {
        assertTrue(engine.isRunning());
        engine.setRunning(false);
        assertTrue(!engine.isRunning());
    }
    
    @Test
    public void engineUpdatesObjects() {
        float posInit = engine.getObjects().get(0).getPosX();
        engine.update(1);
        float posAfter = engine.getObjects().get(0).getPosX();
        assertTrue(posInit!=posAfter);
    }
    
}
