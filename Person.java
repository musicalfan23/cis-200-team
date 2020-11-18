import java.util.*;
import java.lang.*;

public class Person {
    private Ship myShip;
    private int healthPoints;
    private String name;
    private String species;
    private int defenseStats;
    private Weapon weapon;

    Person() {
        this.myship = new Ship();
        this.healthpoint = 100;
        this.name = "";
        this.species = "";
        this.defenseStats = 100;
        this.weapon = new Weapon();
    }

    Person(String name, String species) {
        this.myship = new Ship();
        this.healthPoints = 100;
        this.name = name;
        this.species = species;
        this.defenseStats = 100;
        this.weapon = new Weapon();
    }

    public Ship getMyShip() {
        return this.myShip;
    }

    public int getMyHealthPoints() {
        return this.healthPoints;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getDefenseStats() {
        return this.defenseStats;
    }

    public void setDefenseStats(int defenseStats) {
        this.defenseStats = defenseStats;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String saySomething(int whichPhrase) {

        String s;
        if (whichPhrase == 0) {
            Random rand = new Random();
            whichPhrase = rand.nextInt(9);
            whichPhrase = whichPhrase + 1;
        }
        whichPhrase = Integer.toString(whichPhrase);

        Map<String, String> sayings = new HashMap<String, String>();
        sayings.put("1", "Isn't the weather up here just lovely?");
        sayings.put("2", "We sure are in a pickle.");
        sayings.put("3", "Let's get out of here!");
        sayings.put("4", "Nice work! Your mom will be so proud of you!");
        sayings.put("5", "Hurry up and shoot!");
        sayings.put("6", "Where to next?");
        sayings.put("7", "I can tell it's your first time in space.");
        sayings.put("8", "Wanna take a turn driving?");
        sayings.put("9", "Not as easy as it looks.");
        sayings.put("10", "Not quite as glamorous as Avatar is it?");

        for (String key : sayings.keySet()) {
            if (key.equals(whichPhrase)) {
                s = sayings.getValue();
            }
        }

        return s;
    }
}
