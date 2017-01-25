package fi.lleevi.urbanminigolf.application;

import fi.lleevi.urbanminigolf.ui.GameWindow;
import javax.swing.SwingUtilities;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GameWindow());
    }

}
