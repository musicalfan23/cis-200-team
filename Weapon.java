/**
* Weapon.java
*
* This class creates Weapon objects that serve as the fighting objects for the ship.  
* The weapons must have different damage amounts in order to ensure each game will be different.  
* The weapon also has an ammount of ammo so the player knows how much they can fire.  
* A simple string is used to assign a name so that the player knows what weapon it is.  
* All of these variables must be changeable as the player finds more ammo and changes weapons.
*/

public class Weapon {
	
	String weaponType;
	int damage;
	int ammoRemaining;
	
  /**Weapon()
  * This is the main constructor for the Weapon class. It sets the
  * weaponType, damage, and ammoRemaning instance variables to the values entered through the 
  * parameters.
  *
  * @param wT - A string containing the Weapon object's type
  * @param d - An int containing to ammount of damage the weapon can produce
  * @param aR - An int containing the ammount of ammo remaining in the weapon
  */
	public Weapon(String wT, int d, int aR) {
		weaponType = wT;
		damage = d;
		ammoRemaining = aR;
	}
	
  /** fireWeapon()
  * This method allows other classes to change to damage value of a ship to show a weapon was fired
  * instance variable for the Weapon object.
  *
  * @param  Ship - A object that contains a damage amount
  */
	public void fireWeapon(Ship target) {
		target.takeDamage(damage);
		ammoRemaining--;
	}
	
  /** getWeaponType()
  * This method allows other classes to change to a different weapon for user display
  * instance variable for the Weapon object.
  *
  * @return  weaponType - A String of the type of weapon being used
  */
	public String getWeaponType() {
		return weaponType;
	}
	
  /** getDamage()
  * This method allows other classes to view the amount of damage a weapon produces
  * instance variable for the Weapon object.
  *
  * @return  An int of the amount of damage to dealt
  */
	public int getDamage() {
		return damage;
	}
	
  /** ammoRemaining()
  * This method allows other classes to view the amount of ammo remaining
  * instance variable for the Weapon object.
  *
  * @return   An int of the amount of the ammount of ammo remaining
  */
	public int getAmmoRemaining() {
		return ammoRemaining;
	}
	
  /** setWeaponType()
  * This method allows other classes to change the type of weapon
  * instance variable for the Weapon object.
  *
  * @param wT - A String of the type of weapon to changed to, basically the name
  */
	public void setWeaponType(String wT) {
		weaponType = wT;
	}
	
  /** setDamge()
  * This method allows other classes to change the ammount of damage it causes
  * instance variable for the Weapon object.
  *
  * @param d - An int indicating the ammount of damage dealt by the weapon
  */
	public void setDamage(int d) {
		damage = d;
	}
	
  /** setAmmoRemaining()
  * This method allows other classes to change the ammount of ammo remaining
  * instance variable for the Weapon object.
  *
  * @param aR - An int indicating the ammount of ammo remaining that can be changed to any ammount
  */
	public void setAmmoRemaining(int aR) {
		ammoRemaining = aR;
	}

  /** useAmmo() 
  * This method allows other classes to change the ammount of ammo remaining by one.
  * instance variable for the Weapon object.
  */
	public void useAmmo(){
		ammoRemaining--;
	}
}