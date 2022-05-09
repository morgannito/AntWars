package Ant;

import Map.Map;
import Resource.Resource;
import javafx.beans.Observable;

import java.util.ArrayList;

public class Ant_Worker extends Ant {

    protected ArrayList<Resource> ressouces;

    public Ant_Worker(AnthillColor color, int x, int y) {
        super(color, x, y);
        this.ressouces = new ArrayList<>();
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
                if (Map.getInstance().getTiles()[this.getX()][this.getY()].getAnthill() != null && this.ressouces.size() > 0) {
                        doneRessource();
                }else {
                    if (ressouces.size() > 4) {
                        moveToAnthills();
                    } else {
                        randomMove();
                    }
                    if (Map.getTiles()[this.getX()][this.getY()].getResources().size() > 0 && this.ressouces.size() < 5) {
                    takeRessource();
                    }
                }
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    // prend une ressource si elle est sur la case et s'il n'y a pas deja 5 ressources sur elle
    public void takeRessource() {
        Resource MyResource = Map.getTiles()[this.getX()][this.getY()].getFirstResource();
        ressouces.add(MyResource);
        Map.getTiles()[this.getX()][this.getY()].removeResource(MyResource);
    }

    public void doneRessource() {
        Anthill myAnthill = Map.getInstance().getTiles()[this.getX()][this.getY()].getAnthill();
        Resource myResource = this.ressouces.get(0);
        ressouces.remove(0);
        myAnthill.addRessouce(myResource);
    }

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
