package Ant;

import Resource.Resource;

public abstract class Ant {

    protected boolean isInjured;
    protected Anthill color;
    protected Ant(Anthill color) {
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

    public Anthill getColor() {
        return color;
    }

    public void setColor(Anthill color) {
        this.color = color;
    }

    public abstract void run();

    protected class arrayList<T> {
    }
}

