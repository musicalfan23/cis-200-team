import java.util.*;
/**
* Encounter.java
*
* This class creates Encounter objects that serve as the main enemies 
* for the player to face and destroy. It has one constructor which is 
* passed two Ship objects. It then has a fight method that controls  * the fight via a menu of options for the user to choose from by user 
* input. The fight method also returns whether or not the game is    * over as a boolean value. The class also has a get and set method   * for the instance variable otherShip so that its value can be       * adjusted and gotten by other classes as needed. The class also     * features get and set methods for the location and a get method for 
* the boolean value ranAway. Finally, the class has a method called  * encounterAttack which handles the actual attacking and damage one 
* ship inflicts on another, and the encounterRam method which is used * when a one ship decides to ram another ship in an encounter.
*/
public class Encounter {
  private Ship playerShip;
	private Ship otherShip;
	public boolean isHostile;
	private String location;
	public String dialog;
	private boolean ranAway;
  public int theCount;
  public int theCount1;
	
  
  /** Multi-Argument Constructor
  * This constructor sets the values of the instance variables. Takes * a Ship object instead of creating one.
  *
  *@param pS Player's Ship object
  *@param oS Other Ship object
  *@param dialog String of dialog to initialize the dialog instance variable
  */
  public Encounter(Ship pS, Ship oS, String dialog) {
		playerShip = pS;
    otherShip = oS;
		isHostile = true;
		location = "Some Planet";
		this.dialog = dialog;
		ranAway = false;
	}
  
  /** fight
  * This method controls the fight via a menu of options which the   * user decides from and inputs. The method makes sure the user     * enters in a valid attack, retreat, or do nothing move based off  * its corresponding integer.
  *
  *@param s Scanner object used to get user input
  *@return Whether or not the game is over using the boolean gameOver.
  */
  // this method controls the entire fight
  public boolean fight(Scanner s) {
    boolean gameOver = false;
    boolean continueFighting = true;

    //Uses the encounter dialog to display a message before the fight
    System.out.println(dialog + "\n");
    while (continueFighting){

				boolean invalidInput = false;
				do {
					//Displays each ships hp before each turn and then ask the
					//user what they want to do. 
					System.out.println("Your ship's shield points: " + playerShip.getSP()+ "\nYour ship's hp: " + playerShip.getHP() + "\nEnemy Ship's shield points: " + otherShip.getSP() +
					"\nEnemy ship's hp: " + otherShip.getHP() +"\n\nYour ship's remaining ammo: " +playerShip.getWeapon().getAmmoRemaining()+"\n");
          
          if (playerShip.getHP()<20 & theCount == 0){
						System.out.println("\nWe sure are in a pickle here!\n");
						theCount = 1;
					}
					System.out.print("Options: \n\t 1) Fire the Weapon! \n\t 2) Nothing\n\t 3) Run away to a different planet\n\t 4) Ram the enemy ship!!!\n\nWhat would you like to do: ");

					//reads what the user types
					String input = s.nextLine();

					//if the user press one uses the encounterAttack method to
					// do the attack. 2 for doing nothing, 3 to retreat, and 4 
          // to ram the enemy ship
					if(input.equals("1") && playerShip.getWeapon().getAmmoRemaining() > 0) {
						encounterAttack(playerShip, otherShip);
						invalidInput = false;
					}
					else if (input.equals("2")){
						System.out.println("\nYou did nothing\n");
						invalidInput = false;
					}
					else if (input.equals("3")){
						System.out.print("\nYou have made a strategic retreat...\n\n");
						continueFighting = false;
						invalidInput = false;
						ranAway = true;
					}
					else if (input.equals("4")){
						invalidInput = false;
						encounterRam(playerShip, otherShip);
					}
					else if(playerShip.getWeapon().getAmmoRemaining() <= 0){
						System.out.println("\n\nUnable to fire weapon, input new move. You are out of ammo and can't fire your weapon, consider ramming the enemy ship or running away.\n\n");
						invalidInput = true;
					}
					else{
						invalidInput = true;
						System.out.print("\n\nInvalid input, please enter 1-4.\n\n");
					}
				} while(invalidInput);
        //if the enemy ship has 0 or less hp left sets //continueFighting to false and
        //displays a message
        if(otherShip.getHP() <= 0){
          continueFighting = false;
          System.out.println("\nEnemy Ship destroyed... You won!\n");
          theCount1 = theCount1 + 1;
          if (theCount1 == 1){
            System.out.println("\nNice shot! Your mom will be so proud of you!\n");
            theCount1 = theCount1 + 1;
          }
        }

        //As long as the enemy ship is alive it attacks the player //ship
        if(continueFighting && otherShip.getWeapon().getAmmoRemaining() > 0)
          encounterAttack(otherShip, playerShip);

        //If the player loses all of their hp, the fight and game are
        // over. And display a message stating that they lost.
        if(playerShip.getHP() <= 0){
          continueFighting = false;
          gameOver = true;
          System.out.println("\nYour ship is destroyed and you only barely escaped in an escape pod... You have failed your mission.");
        }
    } // end while

    return gameOver;
  }
	
  /** setEnemyShip
  * This set method sets the enemy ship to the Ship object passed-in.
  *
  *@param s Ship object to set the value of the enemy ship to.
  */
	public void setEnemyShip(Ship s) {
		otherShip = s;
	}
	
  /** getEnemyShip
  * This get method returns the value of the private data property   * otherShip.
  *
  *@return The value of the otherShip private data property.
  */
	public Ship getEnemyShip() {
		return otherShip;
	}
	
  /** setLocation
  * This set method sets the enemy ship to the Ship object passed-in.
  *
  *@param loc String used to set the value of the variable location.
  */
	public void setLocation(String loc) {
		location = loc;
	}
	
  /** getLocation
  * This get method returns the value of the private data property   * location.
  *
  *@return The value of the private data property location.
  */
	public String getLocation() {
		return location;
	}

  /** getRanAway
  * This get method returns the value of the private data property   * ranAway.
  *
  *@return The value of the private data property ranAway.
  */
	public boolean getRanAway() {
		return ranAway;
	}
	
  /** encounterAttack
  * This method fully handles one ship attacking another ship. There * is a 25% chance that an attacj will miss which is based off of a * random integer. This method also deals the damage to the         * defending ship and displays a summary of the attack.
  *
  *@param attacker Ship object that is currently attacking.
  *@param target Ship object that is currently the target of the     *attack.
  */
  //encounterAttack used to fully handle one ship attacking
  // another ship
  // Basically 1/4 chance the attack misses, otherwise the method
  // deals the damage to the ship. It displays a summary of what
  // happened
	public void encounterAttack(Ship attacker, Ship target) {
    
		Random r = new Random();
		int random = r.nextInt(4);
		String attackSummary = "";
		if (random == 1) {
			attackSummary = target.getType() + " evaded "+ attacker.getType() + "'s attack";
			attacker.getWeapon().useAmmo();
		}
		else {
      attacker.getWeapon().fireWeapon(target);
			attackSummary = attacker.getType() + " fired their " +attacker.getWeapon().getWeaponType() + " weapon and it hit dealing " + attacker.getWeapon().getDamage() + " damage";
		}
		System.out.println("\n" + attackSummary + "\n");

	}

	/** encounterRam
	* This method is used when one ships in an encounter rams another.
	* It calls the ship rams method that deals damage to both ships and
	* displays a summary.
	* 
	*@param attacker The ship that is ramming
	*@param target The ship that is getting rammed
	*/
	public void encounterRam(Ship attacker, Ship target) {
		attacker.ramShip(target);
		System.out.println(attacker.getType() +" rammed the enemy ship dealing 40 damage to the enemy and 24 damage to itself.");
	}
	
	
} // end Encounter