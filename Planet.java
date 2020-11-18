import java.util.*;

public class Planet {
    private String name;
    private boolean isColonized;
    private ArrayList<Colony> colonies = new ArrayList<>();
    private double survivability;
    private double size;
    private double gravity;

    public Planet(){

    }

    public Planet(String n, boolean c, double surv, double s, double g){
        this.name = n;
        this.isColonized = c;
        this.survivability = surv;
        this.size = s;
        this.gravity = g;
    }

    public double getSize(){
        return size;
    }

    public String getName(){
        return name;
    }

    public boolean isColonized(){
        return isColonized;
    }

    public ArrayList<Colony> getColonies(){
        return colonies;
    }

    

}
