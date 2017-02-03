package fi.lleevi.urbanminigolf.game;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenderListener implements ActionListener {

    private final GameEngine engine;

    public RenderListener(GameEngine engine) {
        this.engine = engine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        engine.paintImmediately(0, 0, engine.getWidth(), engine.getHeight());
        Toolkit.getDefaultToolkit().sync();
    }

}
