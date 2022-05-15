package Map;

import Ant.*;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Map {



    private static class LoadMap {
        static final Map INSTANCE = new Map();
    }

    private Map() {
        this.width = 20;
        this.height = 20;
        anthills = new ArrayList<Anthill>();
        initMap();
        createAnthill();
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
    public List<Anthill> anthills;

    public static Tile[][] getTiles() {
        return tiles;
    }


    // initialise la map
    public void initMap() {
        tiles = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = new Tile(i, j);
            }
        }
    }


   // dessine la map
    public void displayFx(GraphicsContext gfx) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                tiles[i][j].displayFx(gfx);
            }
        }
    }


    // dessine les fourmis
    public void displayAnt(GraphicsContext gfx) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                tiles[i][j].drawAnt(gfx);
            }
        }
    }


    // déplace les fourmis
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


    // Place les fourmilières
    public void createAnthill() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (i == 19 && j == 0) {
                    tiles[i][j].anthill = new Anthill(AnthillColor.RED, 19, 0);
                    tiles[i][j].anthill.start();
                    anthills.add(tiles[i][j].anthill);
                }
                if (i == 0 && j == 0) {
                    tiles[i][j].anthill = new Anthill(AnthillColor.YELLOW, 0, 0);
                    tiles[i][j].anthill.start();
                    anthills.add(tiles[i][j].anthill);
                }
                if (i == 19 && j == 19) {
                    tiles[i][j].anthill = new Anthill(AnthillColor.BLUE, 19, 19);
                    tiles[i][j].anthill.start();
                    anthills.add(tiles[i][j].anthill);
                }
            }
        }

    }

    // Renvoie le score de chaque fourmilières
    public String getEndScore() {
        String score = "";
        for (Anthill anthill : anthills) {
            score += anthill.getColor() + " : "+ anthill.getScore() + "\n";
        }
        return score;
    }


    // Stop tout les Threads
    public void stopThread() {
        for (Anthill anthill : anthills) {
            anthill.interrupt();
            for (Ant ant : anthill.workers) {
                ant.interrupt();
            }
            for (Ant ant : anthill.soldiers) {
                ant.interrupt();
            }
        }
    }


}
