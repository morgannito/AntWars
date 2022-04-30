package Map;

import Ant.*;
import Resource.*;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Tile   {
    int  x;
    int y;
    ArrayList<Resource> resources;
    ArrayList<Ant> Ants;
    Anthill anthill;


    public Tile(int i, int j) {
        x = i;
        y = j;
            resources = new ArrayList<>();
           for (int k = 0; k < ThreadLocalRandom.current().nextInt(0, 50); k++) {
               Resource resource = new Resource(ResourceType.FOOD);
               resources.add(resource);
           }
        this.Ants = new ArrayList<Ant>();
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


    public ArrayList<Resource> tile() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public void drawBackground(GraphicsContext gc) {
    }

    public void draw(GraphicsContext gc) {
    }

    public void displayFx(GraphicsContext gfx) {
        int taille = 40;
        try {
            if(this.anthill.getColor() == AnthillColor.BLUE){
                gfx.setFill(Color.BLUE);
                gfx.fillRect(x*taille,y*taille,taille,taille);
                gfx.setLineWidth(0.5);
                gfx.setTextAlign(TextAlignment.CENTER);
                gfx.setTextBaseline(VPos.CENTER);
                gfx.setFill(Color.BLACK);
                gfx.fillText(
                        "Text",
                        Math.round(40 / 2),
                        Math.round(40 / 2)
                );
                gfx.setStroke(Color.BLACK);
                gfx.strokeRect(x*taille,y*taille,taille,taille);
            }
            if(this.anthill.getColor() == AnthillColor.RED){
                gfx.setFill(Color.RED);
                gfx.fillRect(x*taille,y*taille,taille,taille);
                gfx.setLineWidth(0.5);
                gfx.setStroke(Color.BLACK);
                gfx.strokeRect(x*taille,y*taille,taille,taille);
            }
            if(this.anthill.getColor() == AnthillColor.YELLOW){
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
            gfx.setTextAlign(TextAlignment.CENTER);
            gfx.setTextBaseline(VPos.CENTER);
            gfx.setFill(Color.BLACK);
            gfx.fillText(
                    this.resources.size()+"",
                    x*taille+5,
                    y*taille+5
            );
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

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }
}
