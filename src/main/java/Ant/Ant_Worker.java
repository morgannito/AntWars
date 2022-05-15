package Ant;

import Map.Map;
import Resource.Resource;
import javafx.beans.Observable;

import java.util.ArrayList;

import static Resource.ResourceType.FOOD;

public class Ant_Worker extends Ant {

    protected ArrayList<Resource> resources;

    public Ant_Worker(AnthillColor color, int x, int y) {
        super(color, x, y);
        this.resources = new ArrayList<>();
    }

    public void update() {
        // todo
    }


    public void addObserver(Observable o) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                if (Map.getTiles()[this.getX()][this.getY()].getAnthill() != null && this.resources.size() > 0) {
                    synchronized (resources) {
                        // pose une resource
                        doneRessource();
                    }
                }else {
                    if (Map.getTiles()[this.getX()][this.getY()].getResources().size() > 0 && this.resources.size() < 5) {
                        // prend une resource
                        takeRessource();
                    }
                    // si la fourmi a 5 ressource elle va a la fourmilière
                    if (resources.size() > 4) {
                        moveToAnthills();
                    } else {
                        // fait un mouvement aléatoire
                        randomMove();
                    }

                }
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    // prend une resource de la case
    public void takeRessource() {
        Resource MyResource = Map.getTiles()[this.getX()][this.getY()].getFirstResource();
        resources.add(MyResource);
        Map.getTiles()[this.getX()][this.getY()].removeResource(MyResource);
    }


   // pose la resources dans la fourmilière
    public void doneRessource() {
        Anthill myAnthill = Map.getInstance().getTiles()[this.getX()][this.getY()].getAnthill();
            Resource myResource = this.resources.get(0);
            // si la ressource est de type food
        synchronized (myResource) {
            if (myResource.getType() == FOOD) {
                myAnthill.addRessouce(myResource);
                resources.remove(0);
            } else {
                // si la ressource est de type Point
                myAnthill.setScore(myAnthill.getScore() + 1);
                resources.remove(0);
            }
        }
    }

    // fonction pour retourner à la fourmilière
    public void moveToAnthills() {
        if (x > anthillsX) {
            Map.getInstance().moveTo(this, Map.getInstance().getLeftTile(this));
        } else if (x < anthillsX) {
            Map.getInstance().moveTo(this, Map.getInstance().getRightTile(this));

        } else if (y > anthillsY) {
            Map.getInstance().moveTo(this, Map.getInstance().getTopTile(this));

        } else if (y < anthillsY) {
            Map.getInstance().moveTo(this, Map.getInstance().getBottomTile(this));
        }
    }
}
