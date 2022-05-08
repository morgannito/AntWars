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
                // deposer une ressource si elle est sur la case anthill
                if (Map.getTiles()[this.getX()][this.getY()].getAnthill() != null && this.ressouces.size() > 0) {
//                    System.out.println("worker found anthill");
                    try {
                        Anthill myAnthill = Map.getTiles()[this.getX()][this.getY()].getAnthill();
                        Resource myResource = this.ressouces.get(0);
                        ressouces.remove(0);
                        myAnthill.addRessouce(myResource);
//                        System.out.println(myAnthill.getResources().size());
                    } catch (Exception e) {
//                        System.out.println("worker found anthill but no ressource");
                    }
                }else {
                    if (ressouces.size() > 4) {
                        if (x > anthillsX) {
                            Map.getInstance().moveTo(this, Map.getInstance().getLeftTile(this));
                        } else if (x < anthillsX) {
                            Map.getInstance().moveTo(this, Map.getInstance().getRightTile(this));

                        } else if (y > anthillsY) {
                            Map.getInstance().moveTo(this, Map.getInstance().getTopTile(this));

                        } else if (y < anthillsY) {
                            Map.getInstance().moveTo(this, Map.getInstance().getBottomTile(this));
                        }
                    } else {
                        randomMove();
                    }

                    // prend une ressource si elle est sur la case et si il n'a pas deja une ressource sur elle
                    if (Map.getTiles()[this.getX()][this.getY()].getResources().size() > 0 && this.ressouces.size() < 5) {
//                    System.out.println("worker found resource");
                        Resource MyResource = Map.getTiles()[this.getX()][this.getY()].getFirstResource();
                        ressouces.add(MyResource);
                        Map.getTiles()[this.getX()][this.getY()].removeResource(MyResource);
                    }
                }

                Thread.sleep(1000);
//                System.out.println("Ant is moving " +this.getX()+" "+this.getY());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
