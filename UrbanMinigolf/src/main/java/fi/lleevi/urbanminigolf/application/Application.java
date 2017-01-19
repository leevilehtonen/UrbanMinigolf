package fi.lleevi.urbanminigolf.application;

import javax.swing.SwingUtilities;

public class Application {
    
    public static void main(String[] args) {
        
        UrbanMinigolf urbanMinigolf = new UrbanMinigolf();
        SwingUtilities.invokeLater(urbanMinigolf);
        
    }
    
}
