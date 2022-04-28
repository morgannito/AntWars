package Map;
import Ant.*;
import Map.*;
import Resource.*;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class Map {

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
        String[] str_array = {"RED", "YELLOW", "BLUE"};
        List<String> list = new ArrayList<String>(Arrays.asList(str_array));
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                // creer un tile
                ArrayList<Ant> ants = new ArrayList<Ant>();
                ArrayList<Resource> resources = new ArrayList<Resource>();
                // ajoute dans la liste ressources un nombre de 1 aléatoire de 1 à 50
                for (int k = 0; k < (int) (Math.random() * 50 + 1); k++) {
                    resources.add(new Resource(ResourceType.FOOD));
                }
                ArrayList<Ant_Worker> ant_workers = new ArrayList<Ant_Worker>();
                ArrayList<Ant_Soldier> ant_soldiers = new ArrayList<Ant_Soldier>();
                try {
                    String color = str_array[(int) (Math.random() * str_array.length)];
                    list.remove(color);
                    str_array = list.toArray(new String[0]);
                    // ajoute 50 fourmi ant_worker
                    for (int k = 0; k < 50; k++) {
                        ant_workers.add(new Ant_Worker(AnthillColor.valueOf(color)));
                    }
                    for (int k = 0; k < 5; k++) {
                        ant_soldiers.add(new Ant_Soldier(AnthillColor.valueOf(color)));
                    }
                    Tile tile = new Tile(new Anthill(ant_workers,ant_soldiers, resources,AnthillColor.valueOf(color)), resources,ants);
                    this.tiles[i][j] =tile;
                }catch (Exception e){
                    Tile tile = new Tile(new Anthill(ant_workers,ant_soldiers, resources,null), resources,ants);
                    this.tiles[i][j] =tile;
                }
            }
        }
    }




    public void display(Map map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
//                System.out.print(this.tiles[i][j].anthill.getColor());
                System.out.print(this.tiles[i][j].anthill.getSoldiers().size());
//                System.out.print();
            }
            System.out.println();
        }
    }

        public void displayFx(GraphicsContext gfx){
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    this.tiles[i][j].displayFx(gfx, i , j);
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
}
