package Map;

import Ant.Ant;
import Ant.Anthill;
import Ant.AnthillColor;
import Resource.Resource;
import Resource.ResourceType;
import javafx.geometry.VPos;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Tile {
    int x;
    int y;
    ArrayList<Resource> resources;
    ArrayList<Ant> Ants;
    Anthill anthill;

    float taille;

    static Image grass = new Image("grass_alt1.png");


    final Object lock = new Object();


    public Tile(int i, int j) {
        x = i;
        y = j;
        taille = 40;
        Ants = new ArrayList<Ant>();
        resources = new ArrayList<>();
        for (int k = 0; k < ThreadLocalRandom.current().nextInt(0, 50); k++) {
            Resource resource = new Resource(ResourceType.FOOD);
            resources.add(resource);
        }
        if (x == 5 && y == 5) {
            anthill = new Anthill(AnthillColor.RED, 5, 5);
        }
        if (x == 0 && y == 0) {
            anthill = new Anthill(AnthillColor.BLUE, 0, 0);
        }
        if (x == 8 && y == 7) {
            anthill = new Anthill(AnthillColor.YELLOW, 8, 7);
        }
    }

    public Anthill getAnthill() {
        return anthill;
    }

    public void addAnt(Ant ant) {
        synchronized (lock) {
            Ants.add(ant);
        }
    }

    public void removeAnt(Ant ant) {
        synchronized (lock) {
            Ants.remove(ant);
        }
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void drawAnt(GraphicsContext gc) {
        synchronized (lock) {
            if (Ants.size() > 0) {
                for (Ant ant : Ants) {
                    // faire une rotation de l'image en fonction du mouvement de l'ant
//                    ImageView iv = new ImageView(ant.antImage);
//                    iv.setRotate(ant.lastMove);
//                    SnapshotParameters params = new SnapshotParameters();
//                    params.setFill(Color.TRANSPARENT);
//                    Image rotatedImage = iv.snapshot(params, null);
                    gc.drawImage(ant.arrayImage.get(ant.lastMove), x * taille + 15, y * taille + 15, taille/2, taille/2);
                }
            }
        }
    }

    public void displayFx(GraphicsContext gfx) {
        synchronized (lock) {
            // adapte la taille de la grille en fonction de la taille de la fenetre
            gfx.setFont(new javafx.scene.text.Font(10));
            gfx.clearRect(x * taille, y * taille, taille, taille);
            if (anthill != null) {
                drawAnthill(gfx,anthill);
            }else {
                drawResources(gfx);
            }
        }
    }

    private void drawResources(GraphicsContext gfx) {
        // met une image sur la grille
         gfx.drawImage(grass, x * taille, y * taille, taille, taille);
//        gfx.setFill(Color.GREEN);
//        gfx.fillRect(x * taille, y * taille, taille, taille);
        gfx.setLineWidth(0.5);
//        gfx.setTextAlign(TextAlignment.CENTER);
//        gfx.setTextBaseline(VPos.CENTER);
//        gfx.setFill(Color.BLACK);
        gfx.fillText(this.resources.size() + "", x * taille + 5, y * taille + 5);
        gfx.setStroke(Color.BLACK);
        gfx.strokeRect(x * taille, y * taille, taille, taille);
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


    public Resource getFirstResource() {
        synchronized (lock) {
            if (!resources.isEmpty())
                return resources.get(0);
            else
                return null;
        }
    }

    public void removeResource(Resource myResource) {
        synchronized (lock) {
            if (!resources.isEmpty())
                resources.remove(myResource);
        }
    }

    public void drawAnthill(GraphicsContext gfx , Anthill anthill) {
        gfx.setFill(Paint.valueOf(anthill.getColor().toString()));
        gfx.fillRect(x * taille, y * taille, taille, taille);
        gfx.setLineWidth(0.5);
        gfx.setTextAlign(TextAlignment.CENTER);
        gfx.setTextBaseline(VPos.CENTER);
        gfx.setFill(Color.BLACK);
        gfx.fillText(anthill.getResources().size() + "", x * taille + (taille / 2), y * taille + (taille / 2));
        gfx.setStroke(Color.BLACK);
        gfx.strokeRect(x * taille, y * taille, taille, taille);
    }
}
