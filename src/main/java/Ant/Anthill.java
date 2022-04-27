package Ant;

import Resource.Resource;

import java.util.ArrayList;

public class Anthill {

    protected ArrayList<Ant_Worker> workers;
    protected ArrayList<Ant_Soldier> soldiers;
    protected ArrayList<Resource> resources;
    protected AnthillColor color;



    public Anthill(ArrayList<Ant_Worker> workers,ArrayList<Ant_Soldier> soldiers, ArrayList<Resource> resources, AnthillColor color){
            this.workers = workers;
            this.soldiers = soldiers;
            this.resources = resources;
            this.color = color;
    }

    public void run(){
        // TODO run anthill
    }

    public void addRessouce(Resource r){
        // TODO add ressource to anthill
    }

    public int getScore(){
        // TODO return score
        return 0;
    };
    public Ant killAnt(Ant a){
        // TODO kill ant
        return null;
    }

    private class arrayList<T> {
    }
}
