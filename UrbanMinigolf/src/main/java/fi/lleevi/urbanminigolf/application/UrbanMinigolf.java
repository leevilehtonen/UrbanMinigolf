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
        Duration deltaTime = Duration.ZERO;
        Instant beginTime = Instant.now();
        while (running) {

            System.out.println(deltaTime.getSeconds());
            deltaTime = Duration.between(beginTime, Instant.now());
        }
    }

}
