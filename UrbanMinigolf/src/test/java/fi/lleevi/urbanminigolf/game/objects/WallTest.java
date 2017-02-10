/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lleevi.urbanminigolf.game.objects;


import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author lleevi
 */
public class WallTest {
    
    Wall wall;
    Ball b;
    
    public WallTest() {
    }

    @Before
    public void setUp() {
        wall = new Wall(0,0);
        b = new Ball(0, 0);
    }
    @Test
    public void collideWallTop() {
        b.setPosX(10);
        assertTrue(wall.hitTop(b));   
    }
    
    @Test
    public void collideWallBot() {
        b.setPosX(10);
        b.setPosY(40);
        assertTrue(wall.hitBottom(b)); 
    }
    
    @Test
    public void collideWallLef() {
        b.setPosY(10);
        b.setVelX(10);
        assertTrue(wall.hitLeft(b));  
    }
    
    @Test
    public void collideWallRig() {
        b.setPosY(10);
        b.setPosX(40);
        assertTrue(wall.hitRight(b));   
    }

}
