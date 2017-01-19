package fi.lleevi.urbanminigolf.application;

import java.awt.Container;
import java.awt.Dimension;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UrbanMinigolf implements Runnable {

    private final int FRAMES_PER_SECOND = 60;
    private final int FRAMES_TO_SKIP = 1000 / FRAMES_PER_SECOND;
    private final int MAX_FRAMES_TO_SKIP = 10;

    private JFrame frame;

    private boolean running;

    @Override
    public void run() {

        running = true;
        createFrame();
        run(1.0 / 60.0);

    }

    private void createFrame() {
        frame = new JFrame("Urban Minigolf");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setPreferredSize(new Dimension(800, 600));
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    private void createComponents(Container container) {
    }

    public void run(double delta) {
        long deltaTime = 0;
        long beginTime = 0;
        long currentTime = 0;
        
        while (running) {
            
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException ex) {
                Logger.getLogger(UrbanMinigolf.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            currentTime = System.nanoTime();
            deltaTime = currentTime-beginTime;
            beginTime = currentTime;
            
            System.out.println(deltaTime/1000000000.0);
        }
    }

}
