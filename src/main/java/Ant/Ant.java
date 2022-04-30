package Ant;

import Map.Map;
import Resource.Resource;

public abstract class Ant extends Thread{

    protected boolean isInjured;
    protected int x;
    protected int y;
    protected AnthillColor color;
    protected Ant(AnthillColor color) {
        this.color = color;
        this.isInjured = false;
    }

    arrayList<Resource> kill() {
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
    public  void run(){
        while(true){
            try{
                // do something
                Map.getInstance().moveTo(this,Map.getInstance().getRightTile(this));
                Thread.sleep(5);
                System.out.println("Ant is moving " +this.getX()+" "+this.getY());
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    };  // run



    protected class arrayList<T> {
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


}

