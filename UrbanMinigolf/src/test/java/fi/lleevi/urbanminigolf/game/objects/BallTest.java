/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lleevi.urbanminigolf.game.objects;

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
public class BallTest {

    Ball b;

    public BallTest() {
    }

    @Before
    public void setUp() {
        b = new Ball(0, 0, Type.Ball);
    }

    @Test
    public void ballInitializedToZero() {
        assertTrue(b.getX()== 0);
        assertTrue(b.getY() == 0);
        assertTrue(b.getVelX()== 0);
        assertTrue(b.getVelY() == 0);
    }

    @Test
    public void updateChangesPosition() {
        b.setVelX(1);
        b.update(1);
        assertTrue(b.getX() > 0);

    }

    @Test
    public void updateWithDeltaZeroNoUpdate() {
        b.update(0);
        assertTrue(b.getX()== 0);
    }

    @Test
    public void ballTypeCorrect() {
        assertTrue(b.getType() == Type.Ball);
    }
    
    @Test
    public void velocityChangeWorks() {
        b.update(0);
        b.setVelX(0);
        b.setVelY(0);
        assertTrue(b.getVelX() == 0 && b.getVelY() == 0);
        b.setVelX(100);
        b.setVelY(100);
        assertTrue(b.velX == 100 && b.getVelY() == 100);
        
    }
    
    

}
