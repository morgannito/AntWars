package Ant;

import Resource.Resource;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Anthill extends Thread {
    private int x;
    private int y;
    public ArrayList<Ant_Worker> workers;
    public ArrayList<Ant_Soldier> soldiers;
    protected ArrayList<Resource> resources;
    protected AnthillColor color;
    public int score;


    public Anthill(AnthillColor color, int x, int y) {
        this.workers = new ArrayList<>();
        this.soldiers = new ArrayList<>();
        this.resources = new ArrayList<>();
        this.color = color;
        score = 0;
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

    public void run() {
        // TODO run anthill
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public void addRessouce(Resource r) {
        synchronized (resources) {
            resources.add(r);
        }
    }

    public ArrayList<Ant_Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(ArrayList<Ant_Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public int getScore() {
        return score;
    }

    public Ant killAnt(Ant a) {
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

    public void setScore(int score) {
        this.score = score;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

}
