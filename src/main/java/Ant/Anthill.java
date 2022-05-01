package Ant;

import Resource.Resource;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Anthill extends Thread {
    private int x;
    private int y;
    protected ArrayList<Ant_Worker> workers;
    protected ArrayList<Ant_Soldier> soldiers;
    protected ArrayList<Resource> resources;
    protected AnthillColor color;


    public Anthill(AnthillColor color , int x, int y) {
        this.workers = new ArrayList<>();
        this.soldiers = new ArrayList<Ant_Soldier>();
        this.resources = new ArrayList<>();
        this.color = color;

        for (int i = 0; i < 50; i++) {
            Ant_Worker w = new Ant_Worker(color, x, y);
            workers.add(w);
            w.start();
        }

        for (int i = 0; i < 5; i++) {
            Ant_Soldier w = new Ant_Soldier(color, x, y);
            soldiers.add(w);
            w.start();
        }
    }

    public void run(){
        // TODO run anthill
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }
}
