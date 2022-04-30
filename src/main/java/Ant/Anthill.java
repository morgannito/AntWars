package Ant;

import Resource.Resource;

import java.util.ArrayList;

public class Anthill extends Thread {




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
        initAnthillAnt();
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void initAnthillAnt(){
        // creer 50 fourmis
        for(int i = 0; i < 50; i++){
            Ant_Worker w = new Ant_Worker(this.color);
            w.start();
            workers.add(w);
        }
        for(int i = 0; i < 5; i++){
            Ant_Soldier w = new Ant_Soldier(this.color);
            w.start();
            soldiers.add(w);
        }
    }

    public void addRessouce(Resource r){
        // TODO add ressource to anthill
    }

    public ArrayList<Ant_Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(ArrayList<Ant_Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public int getScore(){
        // TODO return score
        return 0;
    };
    public Ant killAnt(Ant a){
        // TODO kill ant
        return null;
    }

    public ArrayList<Ant_Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Ant_Worker> workers) {
        this.workers = workers;
    }
    public AnthillColor getColor() {
        return color;
    }

    public void setColor(AnthillColor color) {
        this.color = color;
    }

}
