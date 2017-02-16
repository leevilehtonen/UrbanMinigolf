package fi.lleevi.urbanminigolf.ui;

import fi.lleevi.urbanminigolf.game.GameEngine;
import fi.lleevi.urbanminigolf.game.objects.GameMap;
import fi.lleevi.urbanminigolf.io.FileReader;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;

/**
 * Peli UI ikkuna.
 *
 * @author lleevi
 */
public class GameWindow extends JFrame implements Runnable {

    /**
     * Pelin leveys.
     */
    public static final int GAME_WIDTH = 800;
    /**
     * Pelin korkeus.
     */
    public static final int GAME_HEIGHT = 600;
    /**
     * Pelin otsikko.
     */
    public static final String GAME_TITLE = "Urban Minigolf";

    private GameEngine engine;
    private List<GameMap> maps;
    private int mapCounter;
    
    /**
     * Luo uuden peli-ikkunan.
     */
    public GameWindow() {
        super(GAME_TITLE);
        maps = FileReader.loadGameMaps();
        mapCounter = 0;
    }

    private void initiaizeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        setResizable(false);
        loadNewEngine(getContentPane());
        setUndecorated(true);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);

    }
    /**
     * Luodaan ja ladataan Jframe olioon uusi pelimoottori.
     * 
     * @param container Jframe objektin Container olio
     */
    public void loadNewEngine(Container container) {

        container.add(new GameEngine());

    }

    @Override
    public void run() {
        initiaizeFrame();
    }

}
