package Ant;

import Resource.Resource;
import javafx.beans.Observable;

public class Ant_Worker extends Ant{

     protected arrayList<Resource> ressouces;

    protected Ant_Worker(Anthill color) {
        super(color);
    }

    public void update() {
        // todo
    }



    @Override
    public void run() {
    }
    public void addObserver(Observable o) {

    }
}
