package Ant;

import Ressource.Ressource;
import javafx.beans.Observable;

public class Ant_Worker extends Ant{

     protected arrayList<Ressource> ressouces;

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
