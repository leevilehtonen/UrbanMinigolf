package fi.lleevi.urbanminigolf.application;

import fi.lleevi.urbanminigolf.ui.GameWindow;
import javax.swing.SwingUtilities;

/**
 * Pelin aloitusluokka.
 * 
 * @author lleevi
 */
public class Application {

    /**
     * Pelin aloitspiste, Java main metodi.
     *
     * @param args komnetorivi parametrit
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GameWindow());
    }

}
