package Map;

import Ant.*;
import Resource.*;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class Tile   {
    int  x;
    int y;
    arrayList<Resource> resources;
    arrayList<Ant> Ants;
    Anthill anthill;
    Tile(Anthill anthill, ArrayList<Resource> resources, ArrayList<Ant> ant, int x, int y) {
        this.anthill = anthill;
        this.Ants = new arrayList<Ant>();
        this.resources = new arrayList<Resource>();
    }


    public Anthill getAnthill() {
        return anthill;
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

    public void displayFx(GraphicsContext gfx, int y , int x, Anthill anthill) {
        int taille = 40;

        try {
            if(anthill.getColor() == AnthillColor.BLUE){
                gfx.setFill(Color.BLUE);
                gfx.fillRect(x*taille,y*taille,taille,taille);
                gfx.setLineWidth(0.5);
                gfx.setTextAlign(TextAlignment.CENTER);
                gfx.setTextBaseline(VPos.CENTER);
                gfx.fillText(
                        "Text",
                        Math.round(40 / 2),
                        Math.round(40 / 2)
                );
                gfx.setStroke(Color.BLACK);
                gfx.strokeRect(x*taille,y*taille,taille,taille);
            }
            if(anthill.getColor() == AnthillColor.RED){
                gfx.setFill(Color.RED);
                gfx.fillRect(x*taille,y*taille,taille,taille);
                gfx.setLineWidth(0.5);
                gfx.setStroke(Color.BLACK);
                gfx.strokeRect(x*taille,y*taille,taille,taille);
            }
            if(anthill.getColor() == AnthillColor.YELLOW){
                gfx.setFill(Color.YELLOW);
                gfx.fillRect(x*taille,y*taille,taille,taille);
                gfx.setLineWidth(0.5);
                gfx.setStroke(Color.BLACK);
                gfx.strokeRect(x*taille,y*taille,taille,taille);
            }
        }catch (Exception e){
            gfx.setFill(Color.GREEN);
            gfx.fillRect(x*taille,y*taille,taille,taille);
            gfx.setLineWidth(0.5);
            gfx.setStroke(Color.BLACK);
            gfx.strokeRect(x*taille,y*taille,taille,taille);
        }


    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    private class arrayList<T> {

        public void add(T ant) {

        }

        public void remove(T ant) {
        }
    }
}
