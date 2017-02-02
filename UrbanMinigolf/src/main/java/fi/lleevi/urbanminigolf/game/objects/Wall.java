/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author lleevi
 */
public class Wall extends GameObject{
    

    public Wall(int posX, int posY, Type type) {
        super(posX, posY, 100, 100,type);
    }

    @Override
    public void update(double delta) {
        setBounds((int)getX(), (int)getY(), 100, 100);
    }

    @Override
    public void render(Graphics2D g) {
        g.fill(getBounds());
    }
    
}
