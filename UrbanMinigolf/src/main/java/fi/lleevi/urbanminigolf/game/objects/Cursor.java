/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lleevi.urbanminigolf.game.objects;

import java.awt.Point;

public class Cursor extends Point {

    private boolean canDraw;

    public Cursor() {
        super();
        canDraw = true;
    }

    public boolean canDraw() {
        return canDraw;
    }

    public void setCanDraw(boolean canDraw) {
        this.canDraw = canDraw;
    }

}
