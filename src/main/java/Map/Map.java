package Map;
import Ant.*;
import Map.*;
import Resource.*;
import java.util.ArrayList;

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

    //    abstract Map shared();
    protected int width;
    protected int height;

    protected Tile[][] tiles;
    protected Anthill[] anthills;



    // constructeur
    public Map(int width, int height){
        this.width = width;
        this.height = height;
    }


    public void initMap() {
        // creer une matrice de tiles
       int x = 3;
        this.tiles = new Tile[this.width][this.height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                // creer un tile
                ArrayList<Ant> ants = new ArrayList<Ant>();
                ArrayList<Resource> resources = new ArrayList<Resource>();
                if (x>0) {
                    ArrayList<Ant_Worker> ant_workers = new ArrayList<Ant_Worker>();
                    ArrayList<Ant_Soldier> ant_soldiers = new ArrayList<Ant_Soldier>();

                    Tile tile = new Tile(new Anthill(ant_workers,ant_soldiers, resources,AnthillColor.valueOf("BLUE")), resources,ants);
                    x--;
                }else {
                    Tile tile = new Tile(null, resources,ants);
                }


            }
        }
    }

    public void display(Map map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {



                System.out.print("");
            }
            System.out.println();
        }
    }
}
