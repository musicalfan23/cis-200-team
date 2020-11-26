import java.util.*;
import java.lang.*;
/* Person.java
*
* This class creates a Person object that serve as the main character of the game.  
* The person does less than the ship and is mostly used to say things and keep track of different stats.  
* The person is a lightweight class that allows other classes to call strings and change some stats.
*/

public class Person {
    private Ship myShip;
    private int healthPoints;
    private String name;
    private int defenseStats;

    /**Person()
    * This is the default constructor for the Person class. It sets
    * the instance variable of name to an empty string.
    */
    Person() {
        this.name = "";
    }

    /**Person()
    * This is the main constructor for the Person class. It sets the
    * name instance variable to the name entered through the 
    * parameter.
    *
    * @param name - A string containing the Person object's name
    */
    Person(String name) {
        this.name = name;
    }

    /** getName()
    * This method allows other classes to get the value of the name
    * instance variable for the Person object.
    *
    * @return - A string containing the Person object's name
    */
    public String getName() {
        return this.name;
    }

    /** saySomething()
    * This method creates a set of possible dialog options for the
    * person to say, and returns the one which matches with the
    * number in the parameter
    *
    * @param whichPhrase - An int between 1 and 10, to decide the saying.
    * @return - A string containing the chosen dialog phrase.
    */

    public String saySomething(int whichPhrase) {

        String s = "";
        if (whichPhrase == 0) {
            Random rand = new Random();
            whichPhrase = rand.nextInt(9);
            whichPhrase = whichPhrase + 1;
        }

        Map<Integer, String> sayings = new HashMap<Integer, String>();
        sayings.put(1, "Isn't the weather up here just lovely?");
        sayings.put(2, "We sure are in a pickle.");
        sayings.put(3, "Let's get out of here!");
        sayings.put(4, "Nice work! Your mom will be so proud of you!");
        sayings.put(5, "Hurry up and shoot!");
        sayings.put(6, "Where to next?");
        sayings.put(7, "I can tell it's your first time in space.");
        sayings.put(8, "Wanna take a turn driving?");
        sayings.put(9, "Not as easy as it looks.");
        sayings.put(10, "Not quite as glamorous as Avatar is it?");

        for (int key : sayings.keySet()) {
            if (key == whichPhrase) {
                s = sayings.get(key);
            }
        }

        return s;
    }
}
