package Ant;

import Resource.Resource;
import javafx.beans.Observable;

import java.util.ArrayList;

public class Ant_Worker extends Ant{

     protected ArrayList<Resource> ressouces;

    public Ant_Worker(AnthillColor color, int x, int y) {
        super(color, x, y);
    }

    public void update() {
        // todo
    }



    public void addObserver(Observable o) {

    }
}
