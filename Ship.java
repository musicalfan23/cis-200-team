import java.awt.event.KeyEvent;

/* Ship.java
*
* This class creates a Ship object that serves as the main interaction between the user and the game. 
* The ship contains most of the important stats and data about how the game is going. 
* All of this data can be displayed and called upon while also being changed and modified as the game progresses. 
* Objects for weapons and the current planet are used to give the user options of what to do next.  
* The class also makes sure that damage and shields are not changed the same everytime and instead happen at random intervals.
*/
//ADD EXTENDS SPRITE EVENTUALLY
public class Ship implements Movement {
    private int hp;
    private int shieldNum;
    private String type;
    private String shieldType;
    private double maxSpeed;
    private double currentSpeed;
    private int fuelLeft;
    private int maxFuel;
    private Weapon weapon;
    private Planet currentPlanet;

    /** Ship()
    * This is the default constructor for the Ship class. It sets all
    * of the instance variables to their default values. 
    */
    public Ship(){
        hp = 100;
        shieldNum = 35;
        shieldType = "Standard Polar Shield";
        maxSpeed = 5;
        currentSpeed = 0;
        fuelLeft = 3;
        maxFuel = 5;
        weapon = new Weapon("Basic Laser", 25, 8);
        currentPlanet = null;
        //added type for combat and displaying what the player did
        type = "Your ship";
    }

    /** Ship()
    * This is the main constructor for the Ship class. It takes in
    * several parameters and sets the instance variables to those
    * values.
    *
    * @param hp - an int containing the ship's health
    * @param sN - an int containing the durability of the shield
    * @param sT - a string containing the shield's type
    * @param mS - a double containing the ship's maximum speed
    * @param w - a weapon object to be assigned to the ship
    * @param p - the planet the ship begins on.
    */
    public Ship(int hp, int sN, String sT,double mS, Weapon w, Planet p) {
        this.hp = hp;
        shieldNum = sN;
        shieldType = sT;
        maxSpeed = mS;
        currentSpeed = 0;
        fuelLeft = 3;
        maxFuel = 5;
        weapon = w;
        currentPlanet = p;
        type = "Enemy ship";
    }
    /** getSP()
    * This method allows other classes to access the shield's 
    * durability points.
    *
    * @return - an int containing the shield durability
    */
		public int getSP(){
			return shieldNum;
		}
    /** regenShield()
    * This method resets the shield's durability.
    *
    * This method takes no parameters and returns nothing.
    */
		public void regenShield(){
			shieldNum = 35;
		}

    /** getHP()
    * This method allows other classes to get the ship's health.
    *
    * @return - an int containing the ship's health
    */

    public int getHP(){
        return hp;
    }
    
    /** addHP()
    * This method adds the value of the parameter to the ship's
    * health
    *
    * @param h - an int containing the amount to add to ship's health
    */

    public void addHP(int h) {
      hp = hp + h;
    }

    /** getType()
    * This method allows other classes to get the ship's type
    *
    * @return - a string containing the ship's type
    */

    public String getType() {
      return type;
    }

    /** ramShip()
    * This method allows the ship to do damage to another ship, while
    * also doing damage to itself
    *
    * @param target - a ship object to do damage to
    */

		public void ramShip(Ship target){
			target.takeDamage(40);
			this.takeDamage(24);
		}

    /** takeDamage()
    * This method does the value of the parameter as damage to either
    * the ship or its shield, depending on whether it has shield left
    *
    * @param dam - An int containing the amount of damage to do
    */

    public void takeDamage(int dam){
				if (shieldNum > 0) {
          if(shieldNum < dam){
            dam = dam - shieldNum;
            shieldNum = 0;
          }else{
            shieldNum -= dam;
            dam = 0;
          }
				}
        this.hp -= dam;
				if (shieldNum < 0){
					shieldNum = 0;
				}
    }
    
    /** useFuel()
    * This method allows the ship to use up it's fuel as it travels
    *
    * @param fuel - an int containing the amount of fuel to use.
    */

    public void useFuel(int fuel){
        this.fuelLeft -= fuel;
    }

    /** refuel()
    * This method adds the amount of fuel passed in the parameter to
    * the amount of fuel that is left in the ship's tank, or
    * completely fills up the tank if the parameter's value is high
    * enough
    *
    * @param fuel - an int containing the amount of fuel to add to the tank.
    */

    public void refuel(int fuel){
        if(this.fuelLeft + fuel < maxFuel){
            this.fuelLeft += fuel;
        }else{
            this.fuelLeft = maxFuel;
        }
        
    }

    /** changeWeapon()
    * This method allows for the ship's weapon to be changed to a new
    * weapon.
    *
    * @param newWeapon - A weapon object for the instance variable to
    * be set to
    */

    public void changeWeapon(Weapon newWeapon){
        weapon = newWeapon;
    }

    /** getSpeed()
    * This method allows other classes to access the ship's speed
    *
    * @return - a double containing the ship's current speed.
    */

    public double getSpeed(){
        return currentSpeed;
    }

    /** getFuel()
    * This method allows other classes to get the ship's current fuel
    *
    * @return - an int containing the fuel left in the ship's tank
    */

    public int getFuel(){
        return fuelLeft;
    }

    /** getCurrentPlanet()
    * This method allows other classes to get the current planet that
    * the ship is on
    *
    * @return - a planet object that the ship is currently at.
    */

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    /** getWeapon()
    * This method allows other classes to get the weapon the ship is
    * currently using.
    *
    * @return - The weapon object the ship is using.
    */

    public Weapon getWeapon() {
      return weapon;
    }

    /** move()
    * This method allows the ship to move between planets in the
    * solar system.
    *
    * @param solarSystem - the solar system the ship is in
    * @param chosenPlanet - the planet the ship is headed to
    */

    public void move(SolarSystem solarSystem, int chosenPlanet){
        currentPlanet = solarSystem.getPlanet(chosenPlanet);
				this.useFuel(1);
    }

}
