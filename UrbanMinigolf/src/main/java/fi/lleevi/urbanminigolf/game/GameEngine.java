package fi.lleevi.urbanminigolf.game;

import fi.lleevi.urbanminigolf.game.objects.GameObject;
import fi.lleevi.urbanminigolf.game.objects.Ball;
import fi.lleevi.urbanminigolf.game.objects.Cursor;
import fi.lleevi.urbanminigolf.game.objects.Type;
import fi.lleevi.urbanminigolf.game.objects.Wall;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
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

        for (GameObject object : objects) {
            object.render(g2);
        }

        if (cursor.canDraw()) {
            g.drawLine((int) cursor.getX(), (int) cursor.getY(), (int) ball.getBounds().getCenterX(), (int) ball.getBounds().getCenterY());
        }
    }

    public void update(double delta) {
        ball.update(delta);
    }

    public void addNewGameObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeGameObject(GameObject object) {
        this.objects.remove(object);
    }

    private void initializeMap() {
        ball = new Ball(10, 10, Type.Ball);
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
}
