package Map;

import Ant.Ant;
import Ant.Anthill;
import javafx.scene.canvas.GraphicsContext;


// c'est un singleton qui gere la map

public class Map {

    private static class LoadMap {
        static final Map INSTANCE = new Map();
    }

    private Map() {
        this.width = 20;
        this.height = 20;
        initMap();
    }

    public static Map getInstance() {
        return LoadMap.INSTANCE;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    protected int width;
    protected int height;
    protected static Tile[][] tiles;
    protected static Anthill[] anthills;

    public static Tile[][] getTiles() {
        return tiles;
    }

    public void initMap() {
        tiles = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = new Tile(i, j);
            }
        }
    }

    public void displayFx(GraphicsContext gfx) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                tiles[i][j].displayFx(gfx);
            }
        }
    }


    public void displayAnt(GraphicsContext gfx) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                tiles[i][j].drawAnt(gfx);
            }
        }
    }

    public void moveTo(Ant ant, Tile tile) {
        tiles[ant.getX()][ant.getY()].removeAnt(ant);
        ant.setX(tile.getX());
        ant.setY(tile.getY());
        tile.addAnt(ant);
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public Tile getTopTile(Ant ant) {
        return tiles[ant.getX()][ant.getY() - 1];
    }

    public Tile getBottomTile(Ant ant) {
        return tiles[ant.getX()][ant.getY() + 1];
    }

    public Tile getLeftTile(Ant ant) {
        return tiles[ant.getX() - 1][ant.getY()];
    }

    public Tile getRightTile(Ant ant) {
        return tiles[ant.getX() + 1][ant.getY()];
    }

    public void fight(Tile tile) {
    if (tile.Ants.size() > 1) {
            // TODO: fight
        }
    }
}
