package Map;
import Ant.*;
import Map.*;
import Resource.*;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// c'est un singleton qui gere la map

public  class Map {
    private static class LoadMap {
        static final Map INSTANCE = new Map();
    }
    private Map() {}

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
    // constructeur
    public Map(int width, int height){
        this.width = width;
        this.height = height;
    }

    public static Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public void initMap() {
        this.tiles = new Tile[this.width][this.height];
        // creer un tableau de 3 couleur

        String[] str_array = {"RED","YELLOW","BLUE"};
        List<String> list = new ArrayList<String>(Arrays.asList(str_array));
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                ArrayList<Resource> resources = new ArrayList<Resource>();
                // ajoute dans la liste ressources un nombre de 1 aléatoire de 1 à 50

                try {
                    String color = str_array[(int) (Math.random() * str_array.length)];
                    list.remove(color);
                    str_array = list.toArray(new String[0]);

                    Tile tile = new Tile(new Anthill(null,null, resources,AnthillColor.valueOf(color)), resources,null,i,j);
                    tiles[i][j] =tile;
                }catch (Exception e){
                       for (int k = 0; k < (int) (Math.random() * 50 + 1); k++) {
                        resources.add(new Resource(ResourceType.FOOD));
                    }
                    Tile tile = new Tile(null, resources,null,i,j);
                    tiles[i][j] =tile;
                }
            }
        }
    }




    public void display(Map map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
//                System.out.print(this.tiles[i][j].anthill.getColor());
//                System.out.print(this.tiles[i][j].anthill.getSoldiers().size());
//                System.out.print();
            }
            System.out.println();
        }
    }

        public void displayFx(GraphicsContext gfx){
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    if (tiles[i][j].anthill != null){
                        tiles[i][j].displayFx(gfx, i, j, tiles[i][j].anthill);
                    }
                    else{
                        tiles[i][j].displayFx(gfx, i , j,null);
                    }
                }
            }
        }
    public void draw(GraphicsContext gc){
        for(int i = 0; i< tiles.length; i++){
            for(Tile tile: tiles[i]){
                tile.drawBackground(gc);
            }
        }
        for(int i = 0; i< tiles.length; i++){
            for(Tile tile: tiles[i]){
                tile.draw(gc);
            }
        }
    }

    public Tile getTile(Ant ant){
        return tiles[ant.getX()][ant.getY()];
    }
    public void moveTo(Ant ant, Tile tile){
        tiles[ant.getX()][ant.getY()].removeAnt(ant);
        ant.setX(tile.getX());
        ant.setY(tile.getY());
        tile.addAnt(ant);
    }
    public Tile getTopTile(Ant ant){
        return tiles[ant.getX()][ant.getY()-1];
    }

    public Tile getBottomTile(Ant ant){
        return tiles[ant.getX()][ant.getY()+1];
    }
    public Tile getLeftTile(Ant ant){
        return tiles[ant.getX()-1][ant.getY()];
    }
    public Tile getRightTile(Ant ant){
        return tiles[ant.getX()+1][ant.getY()];
    }
}
