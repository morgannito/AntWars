package Ant;

import Resource.Resource;
import javafx.beans.Observable;

public class Ant_Worker extends Ant{

     protected arrayList<Resource> ressouces;

    public Ant_Worker(AnthillColor color) {
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
