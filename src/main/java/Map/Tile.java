package Map;

import Ant.*;
import Resource.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Tile   {
    arrayList<Resource> resources;
    arrayList<Ant> Ants;
    Anthill anthill;
    Tile(Anthill anthill, ArrayList<Resource> resources, ArrayList<Ant> ant) {
        this.anthill = anthill;
        this.Ants = new arrayList<Ant>();
        this.resources = new arrayList<Resource>();
    }


    public void addAnt(Ant ant){
        this.Ants.add(ant);
    }
    public void removeAnt(Ant ant){
        this.Ants.remove(ant);
    }

    public void dropResource(Resource resource){
        this.resources.add(resource);
    }


    public arrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(arrayList<Resource> resources) {
        this.resources = resources;
    }

    public void drawBackground(GraphicsContext gc) {
    }

    public void draw(GraphicsContext gc) {
    }

    public void displayFx(GraphicsContext gfx,int x , int y) {
        gfx.setFill(Color.GREEN);
        gfx.fillRect(x*40,y*40,40,40);
        gfx.setLineWidth(0.5);
        gfx.setStroke(Color.BLACK);
        gfx.strokeRect(x*40,y*40,40,40);

    }


    private class arrayList<T> {

        public void add(T ant) {

        }

        public void remove(T ant) {
        }
    }
}
