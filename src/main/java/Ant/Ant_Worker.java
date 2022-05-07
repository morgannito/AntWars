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
                randomMove();
                if (Map.getTiles()[this.getX()][this.getY()].getResources().size() > 0 && this.ressouces.size() < 1) {
//                    System.out.println("worker found resource");
                    Resource MyResource = Map.getTiles()[this.getX()][this.getY()].getFirstResource();
                    ressouces.add(MyResource);
                    Map.getTiles()[this.getX()][this.getY()].removeResource(MyResource);
                }

                if (Map.getTiles()[this.getX()][this.getY()].getAnthill() != null) {
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
                }
                Thread.sleep(50);
//                System.out.println("Ant is moving " +this.getX()+" "+this.getY());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
