package fi.lleevi.urbanminigolf.game.objects;

import fi.lleevi.urbanminigolf.game.objects.Ball;
import fi.lleevi.urbanminigolf.game.objects.Hole;
import fi.lleevi.urbanminigolf.game.objects.Wall;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMap {

    private static final int LEVEL_TILES_X_MAX = 20;
    private static final int LEVEL_TILES_Y_MAX = 15;

    private String name;
    private List<Wall> walls;
    private Ball ball;
    private Hole hole;

    /**
     * Luokka, jonka tarkoitus on muuttaa annettu string muuttuja järkeväksi pelikentäksi.
     * @param unParsedFile 
     */
    public GameMap(String unParsedFile) {
        if (unParsedFile.isEmpty()) {
            name = "Empty";
        } else {
            name = parseName(unParsedFile);
            String levelData = parseLevel(unParsedFile);
            createLevelFromData(levelData);

        }
    }

    private String parseName(String unParsedFile) {
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(unParsedFile);
        m.find();
        return m.group(1);
    }

    private String parseLevel(String unParsedFile) {
        unParsedFile = unParsedFile.replaceAll(" ", "");
        String[] split = unParsedFile.split("\"");
        return split[split.length - 1];
    }

    private void createLevelFromData(String levelData) {
        walls = new ArrayList<>();
        int i = 0;
        for (int y = 0; y < LEVEL_TILES_Y_MAX; y++) {
            for (int x = 0; x < LEVEL_TILES_X_MAX; x++) {
                char c = levelData.charAt(i);
                i++;
                if (c == '1') {
                    walls.add(new Wall(x * Wall.WALL_SIZE, y * Wall.WALL_SIZE));
                } else if (c == 'H') {
                    hole = new Hole(x * Wall.WALL_SIZE + Wall.WALL_SIZE / 2 - Hole.HOLE_SIZE / 2, y * Wall.WALL_SIZE + Wall.WALL_SIZE / 2 - Hole.HOLE_SIZE / 2);
                } else if (c == 'B') {
                    ball = new Ball(x * Wall.WALL_SIZE + Wall.WALL_SIZE / 2 - Ball.BALL_SIZE / 2, y * Wall.WALL_SIZE + Wall.WALL_SIZE / 2 - Ball.BALL_SIZE / 2);
                }
            }
        }
       
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Hole getHole() {
        return hole;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

}
