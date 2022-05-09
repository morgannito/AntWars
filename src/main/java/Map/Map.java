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

    public void setTiles(Tile[][] tiles) {
        Map.tiles = tiles;
    }

    public void initMap() {
        tiles = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = new Tile(i, j);

            }
        }
    }


    public void display(Map map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
//                System.out.print(this.tiles[i][j].anthill.getColor());
//                System.out.print(this.tiles[i][j].anthill.getSoldiers().size());
            }
            System.out.println();
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
    public Tile getTile(Ant ant) {
        return tiles[ant.getX()][ant.getY()];
    }

    public void moveTo(Ant ant, Tile tile) {
        tiles[ant.getX()][ant.getY()].removeAnt(ant);
        ant.setX(tile.getX());
        ant.setY(tile.getY());
        tile.addAnt(ant);
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
}
