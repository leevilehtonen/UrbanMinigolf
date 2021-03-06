package fi.lleevi.urbanminigolf.game;

import fi.lleevi.urbanminigolf.listeners.CollisionListener;
import fi.lleevi.urbanminigolf.listeners.RenderListener;
import fi.lleevi.urbanminigolf.listeners.MouseListener;
import fi.lleevi.urbanminigolf.listeners.UpdateListener;
import fi.lleevi.urbanminigolf.game.objects.GameObject;
import fi.lleevi.urbanminigolf.game.objects.Ball;
import fi.lleevi.urbanminigolf.game.objects.Cursor;
import fi.lleevi.urbanminigolf.game.objects.GameMap;
import fi.lleevi.urbanminigolf.game.objects.Wall;
import fi.lleevi.urbanminigolf.io.FileReader;
import fi.lleevi.urbanminigolf.ui.GameWindow;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Pelimoottori, joka sitoo logiikan ja UIn.
 *
 * @author lleevi
 */
public class GameEngine extends JComponent {

    private boolean running = false;

    private List<GameMap> maps;
    private Cursor cursor;

    private Timer updateTimer;
    private Timer renderTimer;
    private Timer collisionTimer;

    private UpdateListener updateListener;
    private RenderListener renderListener;
    private MouseListener mouseListener;
    private CollisionListener collisionListener;

    private GameMap map;

    private ArrayList<GameObject> objects = new ArrayList<>();

    private Ball ball;
    private int mapCounter;
    private int score;
    private String mapName;

    /**
     * Luodaan uusi pelimoottori.
     */
    public GameEngine() {
        loadMaps();
        try {
            initializeNextMap();
        } catch (Exception e) {
        }
        initializeEngine();
    }

    /**
     * Metodissa piirretään pelin grafiikkaa objekti kerrallaan, metodin
     * kutsuminen tapahtuu Timerin avulla.
     *
     * @param g Swing Grpahics olio
     *
     * @see RenderListener
     */
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(renderingHints);
        g2.setColor(Color.GREEN);
        g2.fillRect(0, 0, GameWindow.GAME_WIDTH, GameWindow.GAME_HEIGHT);
        for (GameObject object : objects) {
            object.render(g2);
        }

        if (ball.isHittable()) {
            g2.drawLine((int) cursor.getX(), (int) cursor.getY(), (int) ball.getBounds().getCenterX(), (int) ball.getBounds().getCenterY());
        }
        g2.setColor(Color.WHITE);
        g2.drawString("Score: " + score, 20, 25);
        g2.drawString("Map name: " + mapName, 100, 25);
    }

    /**
     * Metodissa päivitetään pelin objekteja.
     *
     * @param delta Päivitys metodikutsujen välinen aika, jolla voidaan
     * tasoittaa eri tietokoneiden tehoeroja pelin päivityksessä. Tarkistetaan
     * myös pelin päättyminen, jos pallon on reijässä ja ladataan seuraava
     * pelimoottori, jossa on uusi kartta.
     *
     * @see UpdateListener
     */
    public void update(double delta) {
        if (running) {
            try {
                ball.update(delta);
            } catch (Exception e) {
            }

            if (ball != null && ball.isInHole()) {
                running = false;
                try {
                    initializeNextMap();
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * Tarkistaa osumat.
     */
    public void checkCollision() {
        try {
            for (GameObject object : objects) {
                ball.intersectsWith(object);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Lisää pelimoottoriin uuden objektin.
     *
     * @param object Peliin lisättävä uusi objekti
     */
    public void addNewGameObject(GameObject object) {
        this.objects.add(object);
    }

    /**
     * Poistaa pelimoottorista objektin.
     *
     * @param object Pelistä poistettava objekti
     */
    public void removeGameObject(GameObject object) {
        this.objects.remove(object);
    }

    private void loadMaps() {
        FileReader fr = new FileReader();
        maps = fr.loadGameMaps();
        mapCounter = 0;
    }

    /**
     * Luo peliin objektit annetun kartan avulla.
     */
    private void initializeNextMap() throws Exception {
        if (mapCounter >= maps.size()) {
            JOptionPane.showMessageDialog(getParent(), "Game over, score: " + score);
            System.exit(0);
        }

        objects.clear();
        map = maps.get(mapCounter);
        mapCounter++;
        mapName = map.getName();
        ball = map.getBall();
        for (Wall wall : map.getWalls()) {
            addNewGameObject(wall);
        }
        addNewGameObject(map.getHole());
        addNewGameObject(ball);
        running = true;

    }

    private void initializeEngine() {

        cursor = new Cursor();
        updateListener = new UpdateListener(this);
        renderListener = new RenderListener(this);
        mouseListener = new MouseListener(this, cursor);
        collisionListener = new CollisionListener(this);

        renderTimer = new Timer(1, renderListener);
        renderTimer.start();
        updateTimer = new Timer(16, updateListener);
        updateTimer.start();
        collisionTimer = new Timer(0, collisionListener);
        collisionTimer.start();

        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);

        if (renderTimer.isRunning() && updateTimer.isRunning() && collisionTimer.isRunning() && getMouseListeners().length > 0 && getMouseMotionListeners().length > 0) {
            running = true;
        } else {
            running = false;
        }

        score = 0;
    }

    /**
     * Tarkistaa pelin tilan.
     *
     * @return palauttaa onko peli käynnissä.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Asettaa pelin tilan.
     *
     * @param running muutettava pelin tila
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Palauttaa kaikki pelimoottorin objektit.
     *
     * @return pelin objektit
     */
    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    /**
     * Metodia kutsutaan kun hiiren nappia painetaan.
     *
     * @param x kohde johon nopeus suunnataan x suunnassa
     * @param y kohde johon nopeus suunnataan y suunnassa
     *
     * @see MouseListener
     */
    public void hitBall(double x, double y) {
        ball.hit(x - ball.getBounds().getCenterX(), y - ball.getBounds().getCenterY());
        score++;
    }

    /**
     * Palauttaa voidaanko nykyistä palloa lyödä.
     *
     * @return voidaanko palloa lyödä (onko pallo jo pysähtynyt)
     */
    public boolean isHittable() {
        return ball.isHittable();
    }

    /**
     * Asettaa pallon lyömistilan paramterina annetun boolean muuttujan mukaan.
     *
     * @param hittable voidaanko palloa lyödä (onko pallo jo pysähtynyt)
     */
    public void setHittable(boolean hittable) {
        ball.setHittable(hittable);
    }

    /**
     * Palauttaa nykyisen pallon.
     *
     * @return pelissä oleva pallo
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * Asettaa peliin pallon.
     *
     * @param ball asettaa peliin uuden pallon
     */
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    /**
     * Palauttaa pelin sen hetkisen pistetilanteen.
     *
     * @return pelin pistetilanne
     */
    public int getScore() {
        return score;
    }
}
