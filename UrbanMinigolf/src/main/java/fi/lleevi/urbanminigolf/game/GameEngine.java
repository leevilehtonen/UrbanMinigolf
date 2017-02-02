package fi.lleevi.urbanminigolf.game;

import fi.lleevi.urbanminigolf.game.objects.GameObject;
import fi.lleevi.urbanminigolf.game.objects.Ball;
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

public class GameEngine extends JComponent implements MouseMotionListener{

    private boolean running = false;

    private ArrayList<GameObject> objects = new ArrayList<>();
    
    private Wall wall;
    private Ball ball;

    private final Timer updateTimer;
    private final Timer renderTimer;

    private final UpdateListener updateListener;
    private final RenderListener renderListener;

    public GameEngine() {
        initializeMap();

        updateListener = new UpdateListener(this);
        renderListener = new RenderListener(this);

        renderTimer = new Timer(1, renderListener);
        renderTimer.start();
        updateTimer = new Timer(16, updateListener);
        updateTimer.start();
        running = true;
        
        addMouseMotionListener(this);

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

    }

    public void update(double delta) {
        ball.update(delta);
        ball.instersect(wall);
        wall.update(delta);
        
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
        ball.setVelX(5);
        
        wall = new Wall(100, 100, Type.Wall);
        addNewGameObject(wall);
        
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        wall.setLocation(e.getX(), e.getY());
    }

}
