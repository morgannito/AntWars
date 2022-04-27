package Ant;

public abstract class Ant {

    protected Thread t;
    protected boolean isalive;
    protected int id;
//    protected arrayList<Ant_Worker> workers;
//    protected arrayList<Ant_Soldier> soldier;
    protected int position_X;
    protected int position_Y;
    protected int life_points;

    protected enum color{
        red,
        blue,
        green,
        yellow,
    }

    // constructeur
    public Ant(int id, int position_X, int position_Y) {
        this.id = id;
        this.position_X = position_X;
        this.position_Y = position_Y;
        this.life_points = 3;
        this.isalive = true;
    }

    // Accesseurs
    public Thread getT() {
        return t;
    }

    public void setT(Thread t) {
        this.t = t;
    }

    public boolean isIsalive() {
        return isalive;
    }

    public void setIsalive(boolean isalive) {
        this.isalive = isalive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition_X() {
        return position_X;
    }

    public void setPosition_X(int position_X) {
        this.position_X = position_X;
    }

    public int getPosition_Y() {
        return position_Y;
    }

    public void setPosition_Y(int position_Y) {
        this.position_Y = position_Y;
    }

    public int getLife_points() {
        return life_points;
    }

    public void setLife_points(int life_points) {
        this.life_points = life_points;
    }

    // méthodes

    public abstract void run();


    public <Ressource> void addRessource(Ressource ressource) {
        // TODO - implement Ant.Ant.addRessource
        // throw new UnsupportedOperationException();
    }

}

