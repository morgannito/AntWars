package Map;

import Ant.*;
import Resource.*;

public class Tile   {
    arrayList<Resource> resources;
    arrayList<Ant> Ants;
    Anthill anthill;
    Tile(Anthill anthill){
        this.anthill = anthill;
        this.Ants = new arrayList<Ant>();
        this.resources = new arrayList<Resource>();
    }
    public void addAnt(Ant ant){
        this.Ants.add(ant);
    }
    public void removeAnt(Ant ant){
        this.Ants.remove(ant);
    }

    public void dropResource(Resource resource){
        this.resources.add(resource);
    }




    private class arrayList<T> {

        public void add(T ant) {

        }

        public void remove(T ant) {
        }
    }
}
