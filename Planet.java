import java.util.*;

/**
* Planet.java
*
* This class creates Planet objects that serve as the main settings of the game. 
* Each one of the planets must have a name and id so that we can differentiate between them. 
* The planet must also be able to return whether is has a colony located on it and get assigned a colony so that we know what is located on the planet.  
* All of these must be assigned in order to have different attributes for each planet.
*/
public class Planet {
    private String name;
    private boolean isColonized;
    private Colony colony;
    private int idNum;

    /**Planet()
    * This is the default constructor for the Planet
    * class. It does not set anything.
    */
    public Planet(){
      
    }
    /**Planet()
    * This is the main constructor for the Planet class. It sets the
    * name instance variable to the name, isColonized, and idNum entered through the 
    * parameter.
    *
    * @param n - A string containing the Planet object's name
    * @param c - A boolean of whether it is colonized or not
    * @param id - A int of the planet id
    */
    public Planet(String n, boolean c, int id){
        this.name = n;
        this.isColonized = c;
        this.idNum = id;
    }

    /** getName()
    * This method allows other classes to get the value of the name
    * instance variable for the Planet object.
    *
    * @return - A string containing the Planet object's name
    */
    public String getName(){
        return name;
    }

    /** getIDNum()
    * This method allows other classes to get the value of the id
    * instance variable for the Planet object.
    *
    * @return - An int containing the Planet object's id
    */
    public int getIDNum() {
      return idNum;
    }

    /** isColonized()
    * This method allows other classes to get the value of whether the planet is colonized or not
    * instance variable for the Planet object
    *
    * @return - A boolean containing whether the planet is colonized or not
    */
    public boolean isColonized(){
        return isColonized;
    }

    /** getColony()
    * This method allows other classes to get the colony on the planet
    * instance variable for the Planet object
    *
    * @return - A Colony of the specific planet
    */
    public Colony getColony(){
        return colony;
    }
    
    /** toString()
    * This method allows other classes return of string to the command line
    * instance variable for the Planet object
    *
    * @return - A String of the statements about the current colonization of the planet
    */
    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append(name + ": Planet # " + idNum + " in the solar system.");
      if(isColonized){
        sb.append("\nA colony exists");
      }
      else{
        sb.append("\nNot currently colonized.");
      }

      return sb.toString();
    }
}
