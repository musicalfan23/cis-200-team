/**
*SolarFlareApp.java
*
*This application class makes use of many other classes and objects
*to allows the user to play the videogame SolarFlare. First it 
*prompts the user to create a person object. Then creates a default
* ship for them. They can travel to different planets, and fight enemy
* ships. After the destroy an enemy ship they can collect a reward
* from a colony on the planet. Once they defeat the final boss, at
*pluto they win the game.
*/
import java.util.*;
import java.lang.*;

public class SolarFlareApp{

	public static void main(String[]args) throws InterruptedException{
		Scanner s = new Scanner(System.in);

    
    System.out.println("");
    System.out.println("Welcome to SolarFlare");
    System.out.println();

    Person person = getPerson(s);
    
    System.out.println();
    Thread.sleep(2000);
    System.out.println("Your mission " + person.getName() + ":");
    Thread.sleep(1000);
    System.out.println("  Travel the solar system and clear all of the planets for human settlement.");
    System.out.println();
    Thread.sleep(2000);
    System.out.println("You have been equipped with the finest ship in SpaceForce's arsenal.\nIt comes with defenses to protect your health and even cupholders!\nWith the proper training you will have mastery of the solar system.");
		System.out.println();
    Thread.sleep(2000);
    System.out.println("Unfortunately, training is no longer in the budget, so you're going to have to learn on the job,\nbut don't worry, you look intelligent, you'll get the hang of it in no time.\n\nJust pick a planet you would like to clear first and you will be on your way!\n\n");
    Thread.sleep(2000);
    System.out.println("But beware of Pluto...I hear there's a pretty ruthless crew out there, and they're ready to take down anyone who comes their way.\n");
    
    
    Thread.sleep(4000);

    Ship playerShip = new Ship();
    SolarSystem solarSystem = new SolarSystem();
    
    boolean gameOver = false;
    //loop that controls the whole game
    while (!gameOver){

      //removes the planet the player is at so they can't travel to //the
      //planet they are currently at
      if (playerShip.getCurrentPlanet() != null) 
          solarSystem.removePlanet(playerShip.getCurrentPlanet().getIDNum());
      //get the planet the player wants to go to
      int chosenPlanet = -1;

      while (chosenPlanet == -1){
        try{
          chosenPlanet = getNextPlanet(s, solarSystem, playerShip); 
          //moves the player ship to the planet they chose
          playerShip.move(solarSystem, chosenPlanet);
        }catch(IndexOutOfBoundsException oob){
          System.out.println("**Error: That planet does not exist..\n");
          chosenPlanet = -1;
        }
      }
      
			//Creates an encounter using the createEncounter method
      // which creates a randomish weapon and a randomish ship
      // and creates an encounter object
			Encounter encounter = null;
      if (playerShip.getCurrentPlanet().getName().equals("Pluto")){
				Weapon w = new Weapon("Railgun", 28, 35);
				Ship otherShip = new Ship(85, 85, "Super Shield", 5.0, w, playerShip.getCurrentPlanet());
				encounter = new Encounter(playerShip, otherShip, "You have encountered the enemy headquarters, this ship is one of the most dangerous in the galaxy. The massive enemy ship fills you with fear as it approaches and prepares to fight.");
				gameOver = encounter.fight(s);
				if(!gameOver && encounter.getRanAway()){
					System.out.print("\nYou coward! You ran away from the enemy headquarters and have FAILED your mission!\n");
					gameOver = true;
				}
				else if (!gameOver){
					System.out.println("You have destroyed the enemy headquarters and you mission is complete. Congratulations " + person.getName() +" you have won!!!");
					gameOver = true;
				}
			}
      else {
        encounter = createEncounter(playerShip);
				//Uses the encounter.fight method to have the player
      	// fight an enemy ship. Returns true if the player
      	// died and the game is over.
      	gameOver = encounter.fight(s);
      }

      if (!gameOver && !encounter.getRanAway()){
        Colony colony = createColony(playerShip.getCurrentPlanet()  );
        if (colony != null)
          colony.encounterColony(playerShip);
      }

			if(!gameOver && playerShip.getFuel() <= 0){
				System.out.print("\nUnfortunately you ship has run out of fuel. You hope that some ship will here your message and save you while your stranded out in space. It will take too long for a ship to get here. You have FAILED your mission!");
				gameOver = true;
			}
			if(!gameOver){
				playerShip.regenShield();
			}
    } // end while that controls game
    

    

    System.exit(0);
	}

	/**createColony
	* This method creates a colony object on the planet given using the 
	* default constructor. It uses a random int that represents a 2/3  * chance of there being a colony
	*
	*@param currentPlanet The planet to make the colony on.
	*@return colony The colony that was created.
	*/
  public static Colony createColony(Planet currentPlanet) {
    Random r = new Random();
    int colonyChance = r.nextInt(3);
    Colony colony = null;

    if(colonyChance == 1 || colonyChance == 2 && currentPlanet.isColonized()){
      colony = new Colony();
    }
    
    return colony;
  }

	/**createEncounter
	* This method uses random ints to create a random ship that
	* gets a random weapon. It then uses that ship to create an *encounter.
	*
	*@param playerShip The player's ship that encounters another ship.
	*@return encounter An encounter object that was created using the random ship and the player ship and some dialog.
	*/
  public static Encounter createEncounter(Ship playerShip) {
    Random r = new Random();

    //Uses a random to choose which weapon to create based on whether
    // whichWeapon is 0 through 4
    //Each weapon also uses a random int which will adjust its damage
    int whichWeapon = r.nextInt(5);
    Weapon w = null;
    if (whichWeapon == 0){
      int damage = r.nextInt(10) + 5;
      w = new Weapon("Railgun", damage, 35);
    }
    if (whichWeapon == 1) {
      int damage = r.nextInt(4) + 18;
      w = new Weapon("Incendiary", damage, 50);
    }
		if (whichWeapon == 2){
			int damage = r.nextInt(3) + 14;
      w = new Weapon("Ion Pulse", damage, 40);
		}
		if (whichWeapon == 3){
			int damage = r.nextInt(2) + 11;
      w = new Weapon("Piercing Laser", damage, 45);
		}
		if (whichWeapon == 4){
			int damage = r.nextInt(17) + 7;
      w = new Weapon("Photon Beam", damage, 32);
		}
    //Uses a random int to choose which of the 5 ships to create
    //Which ever ship is chosen is given the weapon created above.
    //By combining a random weapn with a random ship there are more
    //total combinations of ships that can be made. 
    int whichShip = r.nextInt(5);
    Ship otherShip = null;
    if(whichShip == 0)
		  otherShip = new Ship(50, 50, "Deflector", 5.0, w, playerShip.getCurrentPlanet());
    if(whichShip == 1)
      otherShip = new Ship(40, 75, "Quantum", 4.0, w, playerShip.getCurrentPlanet());
		if(whichShip == 2)
      otherShip = new Ship(20, 90, "Venix", 6.0, w, playerShip.getCurrentPlanet());
		if(whichShip == 3)
      otherShip = new Ship(105, 0, "Primitive", 2.0, w, playerShip.getCurrentPlanet());
		if(whichShip == 4)
      otherShip = new Ship(75, 5, "Polar", 2.0, w, playerShip.getCurrentPlanet());

    //Uses the above ship and the player ship to create an encounter
    //object. Perhaps the encounter should use a random int to
    //add random dialog
    Encounter encounter = new Encounter(playerShip, otherShip, "You have encountered an enemy ship");

    return encounter;
  }

	/** getNextPlanet
	* This method gets the next planet that the user wants to go to.
	* It takes a number, error checks it, and returns that planet
	using the planets id.
	*
	*@param s Scanner used to get user input.
	*@param solarSystem Used to get the list of planets, available to travel to.
	*@param playerShip The player ship that will travel to a new planet.
	*/
	public static int getNextPlanet(Scanner s, SolarSystem solarSystem, Ship playerShip)throws InterruptedException {
    ArrayList<Planet> planets = solarSystem.getPlanetsList();
    int chosenPlanet = -1;

    while(chosenPlanet == -1){
      for (int i = 0; i < planets.size(); i ++){
        if (planets.get(i)!= null)
         System.out.println(planets.get(i));
      }
			System.out.print("\nFuel Left: " + playerShip.getFuel() + "\n");
      System.out.print("\nWhat planet would you like to travel to: ");
      try{
        chosenPlanet = Integer.parseInt(s.nextLine());
        if(planets.get(chosenPlanet-1) == null){
          throw new NumberFormatException();
        }
      }catch(NumberFormatException nf){
        System.out.println("**Error: Please enter a valid planet number..\n");
        chosenPlanet = -1;
      }
    }
    return chosenPlanet;
  }

	/**getPerson
	* This method creates a person object by getting user input, *errorchecking it, and using that to create the person.
	*
	*@param s Scanner used to get person's name from user.
	*@return Person Returns a person object with the name entered.
	*/
  public static Person getPerson(Scanner s) {
    System.out.print("Prepare for your adventure by sharing your name: ");
    String name = "";
    name = s.nextLine();
    if (name == "") {
      while (name == "") {
      System.out.println("You MUST enter a name voyager!");
      System.out.print("Prepare for your adventure by sharing your name: ");
      name = s.nextLine();
      }
    }
    Person person = new Person(name);
    return person;
  }

}