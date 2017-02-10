package fi.lleevi.urbanminigolf.ui;

import fi.lleevi.urbanminigolf.game.GameEngine;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;


/**
 * Peli UI ikkuna
 * @author lleevi
 */
public class GameWindow extends JFrame implements Runnable {

    /**
     * Pelin leveys
     */
    public static final int GAME_WIDTH = 800;
    /**
     * Pelin korkeus
     */
    public static final int GAME_HEIGHT = 600;
    /**
     * Pelin otsikko
     */
    public static final String GAME_TITLE = "Urban Minigolf";

    private GameEngine engine;

    public GameWindow() {
        super(GAME_TITLE);
    }

    private void initiaizeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        setResizable(false);
        createFrameComponents(getContentPane());
        setVisible(true);
        pack();
        setLocationRelativeTo(null);

    }

    private void createFrameComponents(Container container) {
        engine = new GameEngine();
        container.add(engine);
    }

    @Override
    public void run() {
        initiaizeFrame();
    }

}
