/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lleevi.urbanminigolf.game.objects;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

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
        assertTrue(b.getPosX() == 0);
        assertTrue(b.getPosY() == 0);
        assertTrue(b.getVelX() == 0);
        assertTrue(b.getVelY() == 0);
    }

    @Test
    public void updateChangesPosition() {
        b.setVelX(1);
        b.setVelY(1);
        b.update(1);
        assertTrue(b.getPosX() > 0);
        assertTrue(b.getPosY() > 0);

    }

    @Test
    public void updateWithDeltaZeroNoUpdate() {
        b.update(0);
        assertTrue(b.getPosX() == 0);
        assertTrue(b.getPosY() == 0);
    }
    
    @Test
    public void updateWithDeltaOneNoSpeed() {
        b.update(1);
        assertTrue(b.getPosX() == 0);
        assertTrue(b.getPosY() == 0);
    }
    
    @Test
    public void updateWithDeltaOneWithSpeed() {
        b.hit(100, 100);
        b.update(1);
        assertTrue(b.getPosX() != 0);
        assertTrue(b.getPosY() != 0);
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
    @Test
    public void hittingChangesSpeed() {
        double initSpeedX = b.getVelX();
        double initSpeedY = b.getVelY();
        b.hit(100, 100);
        assertTrue(initSpeedX!=b.getVelX());
        assertTrue(initSpeedY!=b.getVelY());
    }
    @Test
    public void hittingWithZeroNotChangeSpeed() {
        double initSpeedX = b.getVelX();
        double initSpeedY = b.getVelY();
        b.hit(0, 0);
        assertTrue(initSpeedX==b.getVelX());
        assertTrue(initSpeedY==b.getVelY());
    }
    
    @Test
    public void speedIsReducing() {
        b.hit(100, 100);
        double initSpeedX = b.getVelX();
        double initSpeedY = b.getVelY();
        for (int i = 0; i < 10; i++) {
            b.update(1);
            
        }
        assertTrue(initSpeedX>b.getVelX());
        assertTrue(initSpeedY>b.getVelY());
        
    }
    
    @Test
    public void movementWillStopAtSpeedThreshold() {
        b.hit(1, 1);
        for (int i = 0; i < 10; i++) {
            b.update(1);
            
        }
        System.out.println(b.getVelX());
        assertTrue(b.getVelX()==0);
        assertTrue(b.getVelY()==0);
        
    }
    @Test
    public void mirrorPositiveSpeed() {
        b.setVelX(100);
        b.setVelY(100);
        b.mirrorXVel();
        b.mirrorYVel();
        assertTrue(b.getVelX()==-100);
        assertTrue(b.getVelY()==-100);
    }
    
    @Test
    public void mirrorNegativeSpeed() {
        b.setVelX(-100);
        b.setVelY(-100);
        b.mirrorXVel();
        b.mirrorYVel();
        assertTrue(b.getVelX()==100);
        assertTrue(b.getVelY()==100);
    }

}
