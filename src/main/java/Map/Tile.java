package Map;

import Ant.Ant;
import Ant.Anthill;
import Ant.AnthillColor;
import Resource.Resource;
import Resource.ResourceType;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Tile {
    int x;
    int y;
    ArrayList<Resource> resources;
    ArrayList<Ant> Ants;
    Anthill anthill;

    final Object lock = new Object();


    public Tile(int i, int j) {
        x = i;
        y = j;
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

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public void drawBackground(GraphicsContext gc) {
    }

    public void draw(GraphicsContext gc) {
        synchronized (lock) {
            if (Ants.size() > 0) {
                for (Ant ant : Ants) {
                    // convertie la couleur de la fourmi en paint javafx
                    // transforme la couleur en string
                    String color = ant.getColor().toString();
                    // transforme la couleur en color javafx
                    Color antColor = Color.valueOf(color);
                    gc.setFill(antColor);
                    gc.fillOval(x * 40 + 15, y * 40 + 15, 10, 10);

                }
            }
        }
    }

    public void displayFx(GraphicsContext gfx) {
        synchronized (lock) {
            // adapte la taille de la grille en fonction de la taille de la fenetre
            gfx.setFont(new javafx.scene.text.Font(20));
            gfx.setTextAlign(TextAlignment.CENTER);
            gfx.setTextBaseline(VPos.CENTER);
            int taille = 40;
            try {
                if (this.anthill.getColor() == AnthillColor.BLUE) {
                    gfx.setFill(Color.BLUE);
                    gfx.fillRect(x * taille, y * taille, taille, taille);
                    gfx.setLineWidth(0.5);
                    gfx.setTextAlign(TextAlignment.CENTER);
                    gfx.setTextBaseline(VPos.CENTER);
                    gfx.setFill(Color.BLACK);
                    gfx.fillText(
                            anthill.getResources().size() + "",
                            x * taille + 5,
                            y * taille + 5
                    );
                    gfx.setStroke(Color.BLACK);
                    gfx.strokeRect(x * taille, y * taille, taille, taille);
                }
                if (this.anthill.getColor() == AnthillColor.RED) {
                    gfx.setFill(Color.RED);
                    gfx.fillRect(x * taille, y * taille, taille, taille);
                    gfx.setLineWidth(0.5);

                    gfx.setTextAlign(TextAlignment.CENTER);
                    gfx.setTextBaseline(VPos.CENTER);
                    gfx.setFill(Color.BLACK);
                    gfx.fillText(
                            anthill.getResources().size() + "",
                            x * taille + 5,
                            y * taille + 5
                    );
                    gfx.setStroke(Color.BLACK);
                    gfx.strokeRect(x * taille, y * taille, taille, taille);
                }
                if (this.anthill.getColor() == AnthillColor.YELLOW) {
                    gfx.setFill(Color.YELLOW);
                    gfx.fillRect(x * taille, y * taille, taille, taille);
                    gfx.setLineWidth(0.5);

                    gfx.setTextAlign(TextAlignment.CENTER);
                    gfx.setTextBaseline(VPos.CENTER);
                    gfx.setFill(Color.BLACK);
                    gfx.fillText(
                            anthill.getResources().size() + "",
                            x * taille + 5,
                            y * taille + 5
                    );
                    gfx.setStroke(Color.BLACK);
                    gfx.strokeRect(x * taille, y * taille, taille, taille);
                }
            } catch (Exception e) {
                gfx.setFill(Color.GREEN);
                gfx.fillRect(x * taille, y * taille, taille, taille);
                gfx.setLineWidth(0.5);
                gfx.setTextAlign(TextAlignment.CENTER);
                gfx.setTextBaseline(VPos.CENTER);
                gfx.setFill(Color.BLACK);
                gfx.fillText(
                        this.resources.size() + "",
                        x * taille + 5,
                        y * taille + 5
                );
                gfx.setStroke(Color.BLACK);
                gfx.strokeRect(x * taille, y * taille, taille, taille);
            }
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
}
