package Map;
import Map.Tile;
import Ant.*;
public abstract class Map {
    abstract Map shared();
    protected Tile[][] tiles;
    protected Anthill[] anthills;



    // constructeur
    public Map(){}

}
