package fi.lleevi.urbanminigolf.game.objects;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class HoleTest {

    Hole hole;
    
    public HoleTest() {
        
    }
    
    @Before
    public void setUp() {
        hole = new Hole(50, 50);
    }
    @Test
    public void ballCollisionNot() {
        Ball b = new Ball(0, 0);
        assertTrue(!hole.intersectsBall(b));
    }
    
    @Test
    public void ballCollisionYes() {
        Ball b = new Ball(50, 50);
        assertTrue(hole.intersectsBall(b));
    }
}
