import java.util.*;

/**
* Colony.java
*
* This class serves to create colonies on planets and gives each     
* colony the supplies that the colony will give to the user to aid in 
* their journey. It has a default constructor that uses a random     
* number so that there are four different supply combinations that a * player can receive. This class also has a get and set method for   
* the HashMap of supplies so that other classes can either add or get 
* the supplies. It finally has an encounterColony method which gives 
* the player their supplies and also displays what they were given   
* from the colony, and a createColonyMessage method that returns a   
* random dialog from the colonies.
*/
public class Colony {
	private HashMap<String, Integer> supplies;
	private int colonyType;
  
  /** Default Colony Constructor 
  * This constructor uses a random integer to assign the Colony      * object with one of the four different types of supply options.
  */
	public Colony() {
		supplies = new HashMap<>();
    Random r = new Random();
    // random integer to decide the type of colony
    colonyType = r.nextInt(4);
    // the supplies are put in a HashMap so that the value can be   // stored with the type of supplies
    if (colonyType == 0) {
        supplies.put("Ammo", r.nextInt(10) + 3);
        supplies.put("Fuel", r.nextInt(3) + 1);
    }
    else if (colonyType == 1) {
      supplies.put("Ship Repairing Supplies", r.nextInt(20) + 15);
      supplies.put("Weapon Damage Increase", r.nextInt(5) + 5);
    }
    else if (colonyType == 2) {
      supplies.put("Ship Repairing Supplies", r.nextInt(20) + 15);
      supplies.put("Ammo", r.nextInt(10) + 3);
    }
    else if (colonyType == 3) {
      supplies.put("Fuel", r.nextInt(3) + 1);
      supplies.put("Weapon Damage Increase", r.nextInt(5) + 5);
    }
	}
	
  /** addSupplies
  * This method takes a string and integer parameter and adds them to * the HashMap of supplies.
  *
  *@param s String value used for the key in the Hashmap. 
  *@param amount Integer value to assign to the corresponding key.
  */
	public void addSupplies(String s, int amount) {
		supplies.put(s, amount);
	}
	
  /** getSupplies
  * This method returns the value of the private HashMap of supplies.
  *
  *@return The private HashMap of supplies.
  */
	public HashMap<String, Integer> getSupplies() {
		return supplies;
	}
  
  /** encounterColony
  * This method changes the values of the player's ship based off    * what supplies they were given and is then used to display the    * supplies that the player got from the colony. This method        * controls how the player and their ship get to interact with a    * colony.
  *
  *@param playerShip The player's ship object that is needed to give *the player the supplies that the colony offers them.
  */
  public void encounterColony(Ship playerShip) {

    System.out.println(createColonyMessage());

    if (colonyType == 0) {
        System.out.println("Ammo: " + supplies.get("Ammo"));
        System.out.println("Fuel: " + supplies.get("Fuel") + "\n");
        playerShip.getWeapon().setAmmoRemaining(playerShip.getWeapon().getAmmoRemaining() + supplies.get("Ammo"));
        playerShip.refuel(supplies.get("Fuel"));
    }
    else if (colonyType == 1) {
      System.out.println("Ship Repairing Supplies: " + supplies.get("Ship Repairing Supplies"));
      System.out.println("Weapon Damage Increase: " + supplies.get("Weapon Damage Increase")  + "\n");
      playerShip.addHP(supplies.get("Ship Repairing Supplies"));
      playerShip.getWeapon().setDamage(supplies.get("Weapon Damage Increase") + playerShip.getWeapon().getDamage());
    }
    else if (colonyType == 2) {
      System.out.println("Ship Repairing Supplies: " + supplies.get("Ship Repairing Supplies"));
      System.out.println("Ammo: " + supplies.get("Ammo")  + "\n");
      playerShip.addHP(supplies.get("Ship Repairing Supplies"));
      playerShip.getWeapon().setAmmoRemaining(playerShip.getWeapon().getAmmoRemaining() + supplies.get("Ammo"));
    }
    else if (colonyType == 3) {
      System.out.println("Fuel: " + supplies.get("Fuel"));
      System.out.println("Weapon Damage Increase: " + supplies.get("Weapon Damage Increase") + "\n");
      playerShip.refuel(supplies.get("Fuel"));
      playerShip.getWeapon().setDamage(supplies.get("Weapon Damage Increase") + playerShip.getWeapon().getDamage());
    }

  }
  
  /** createColonyMessage
  * This method assigns a random message from the colony when they   * are interacting with the player based off of a random integer.
  *
  *@return The colony's message to the player.
  */
  public String createColonyMessage() {
    String message = "";
    Random r = new Random();
    // random integer to decide which message to return
    int whichMessage = r.nextInt(4);
    if (whichMessage == 0) {
      message = "The local Colony has gifted you with the following supplies: ";
    }
    else if (whichMessage == 1){
      message = "The friendly Colony showers you and your ship with supplies: ";
    }
    else if (whichMessage == 2) {
      message = "Supplies rain down from the local Colony and into your ship: ";
    }
    else {
      message = "The locals from the Colony grant you the following supplies to aid on your expedition: ";
    }
    return message;
  } // end createColonyMessage
  
} // end Colony