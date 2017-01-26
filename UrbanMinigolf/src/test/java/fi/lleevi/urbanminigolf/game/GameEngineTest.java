/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lleevi.urbanminigolf.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

}
