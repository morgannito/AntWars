package Ant;

import Resource.Resource;

public abstract class Ant {

    protected boolean isInjured;
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

    public abstract void run();

    protected class arrayList<T> {
    }

}

