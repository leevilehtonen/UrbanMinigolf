package fi.lleevi.urbanminigolf.game;

import fi.lleevi.urbanminigolf.game.objects.GameObject;
import fi.lleevi.urbanminigolf.game.objects.Ball;
import fi.lleevi.urbanminigolf.game.objects.Cursor;
import fi.lleevi.urbanminigolf.game.objects.Hole;
import fi.lleevi.urbanminigolf.game.objects.Wall;
import fi.lleevi.urbanminigolf.ui.GameWindow;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GameEngine extends JComponent {

    private boolean running = false;

    private Cursor cursor;

    private Timer updateTimer;
    private Timer renderTimer;

    private UpdateListener updateListener;
    private RenderListener renderListener;
    private MouseListener mouseListener;

    private ArrayList<GameObject> objects = new ArrayList<>();

    private Ball ball;

    public GameEngine() {
        initializeMap();
        initializeEngine();
    }

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
            g.drawLine((int) cursor.getX(), (int) cursor.getY(), (int) ball.getBounds().getCenterX(), (int) ball.getBounds().getCenterY());
        }
    }

    public void update(double delta) {
        if (running) {
            ball.update(delta);
            for (GameObject object : objects) {
                ball.intersectsWith(object);
            }
            if(ball.isInHole()) {
                running = false;
            }

        }
    }

    public void addNewGameObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeGameObject(GameObject object) {
        this.objects.remove(object);
    }

    private void initializeMap() {

        addNewGameObject(new Hole(300, 300));
        addNewGameObject(new Wall(100, 100));
        addNewGameObject(new Wall(160, 100));

        ball = new Ball(10, 10);
        addNewGameObject(ball);
    }

    private void initializeEngine() {

        cursor = new Cursor();
        updateListener = new UpdateListener(this);
        renderListener = new RenderListener(this);
        mouseListener = new MouseListener(this, cursor);

        renderTimer = new Timer(1, renderListener);
        renderTimer.start();
        updateTimer = new Timer(16, updateListener);
        updateTimer.start();

        running = true;

        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public void hitBall(double x, double y) {
        ball.hit(x - ball.getBounds().getCenterX(), y - ball.getBounds().getCenterY());
    }

    public boolean isHittable() {
        return ball.isHittable();
    }

    public void setHittable(boolean hittable) {
        ball.setHittable(hittable);
    }
}
