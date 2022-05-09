package Ant;

import Map.Map;
import Resource.Resource;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Ant extends Thread {

    protected boolean isInjured;
    protected int x;
    protected int y;
    public AnthillColor color;
    public int anthillsX;
    public int anthillsY;
    public Image antImage;

    public int lastMove;

    public List<Image> arrayImage;

    protected Ant(AnthillColor color, int x, int y) {
        this.x = x;
        this.y = y;
        arrayImage = new ArrayList<>();

        this.color = color;
        if (color == AnthillColor.BLUE) {
            antImage = new Image("ant_blue.png");
            rotateImage();
        }if (color == AnthillColor.YELLOW) {
            antImage = new Image("ant_grey.png");
            rotateImage();
        }if (color == AnthillColor.RED) {
            antImage = new Image("ant_red.png");
            rotateImage();
        }
        this.isInjured = false;
        anthillsX = x;
        anthillsY = y;
    }

    ArrayList<Resource> kill() {
        return null;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public AnthillColor getColor() {
        return color;
    }

    public void setColor(AnthillColor color) {
        this.color = color;
    }


    @Override
    public void run() {
        while (true) {
            try {
                randomMove();
                Thread.sleep(50);
//                System.out.println("Ant is moving " +this.getX()+" "+this.getY());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void randomMove() {
        try {
            synchronized (ThreadLocalRandom.current()) {
                int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, 4);
                switch (boundedRandomValue) {
                    case 0:
                        lastMove = 2;
                        Map.getInstance().moveTo(this, Map.getInstance().getBottomTile(this));
                        break;
                    case 1:
                        lastMove = 0;
                        Map.getInstance().moveTo(this, Map.getInstance().getTopTile(this));
                        break;
                    case 2:
                        lastMove = 3 ;
                        Map.getInstance().moveTo(this, Map.getInstance().getLeftTile(this));
                        break;
                    case 3:
                        lastMove = 1;
                        Map.getInstance().moveTo(this, Map.getInstance().getRightTile(this));
                        break;
                }
            }
        } catch (Exception e) {
            randomMove();
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

    public void rotateImage() {
        if (antImage != null) {
            ArrayList<Integer> myAngles = new ArrayList<>();
            myAngles.add(0);
            myAngles.add(90);
            myAngles.add(180);
            myAngles.add(270);
            for (Integer myAngle : myAngles) {
                ImageView iv = new ImageView(antImage);
                iv.setRotate(myAngle);
                SnapshotParameters params = new SnapshotParameters();
                params.setFill(Color.TRANSPARENT);
                Image rotatedImage = iv.snapshot(params, null);
                this.arrayImage.add(rotatedImage);
            }}
        }
}

