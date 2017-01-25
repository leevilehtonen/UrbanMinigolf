package fi.lleevi.urbanminigolf.game;

import fi.lleevi.urbanminigolf.game.objects.GameObject;
import fi.lleevi.urbanminigolf.game.objects.Ball;
import fi.lleevi.urbanminigolf.game.objects.Type;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GameEngine extends JComponent {

    private boolean running;

    private ArrayList<GameObject> objects = new ArrayList<>();

    private final Timer updateTimer;
    private final Timer renderTimer;

    private final UpdateListener updateListener;
    private final RenderListener renderListener;

    public GameEngine() {
        running = true;
        initializeMap();

        updateListener = new UpdateListener(this);
        renderListener = new RenderListener(this);

        renderTimer = new Timer(0, renderListener);
        renderTimer.start();
        updateTimer = new Timer(16, updateListener);
        updateTimer.start();

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
        for (GameObject object : objects) {
            object.update(delta);
        }
    }

    public void addNewGameObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeGameObject(GameObject object) {
        this.objects.remove(object);
    }

    private void initializeMap() {
        addNewGameObject(new Ball(10, 10, Type.Ball));
    }

}
