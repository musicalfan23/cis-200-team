import java.util.*;
public class Encounter extends Ship {
	private Ship ship;
	public boolean isHostile;
	private String location;
	public String dialog;
	private int getAway;
	
	public Encounter() {
		// I used the UML for Ship and Weapon variables. I wasn't sure what type of stats we wanted the enemy ships to have.
		Weapon w = new Weapon("Incendiary", 20.0, 50.0);
		ship = new Ship(200, 2, "Deflector", 75.0, 100.0, 125.0, w);
		isHostile = true;
		location = "Unidentified Planet";
		dialog = "You have encountered an enemy ship";
		getAway = 0;
	}
	
	public void setEnemyShip(Ship s) {
		ship = s;
	}
	
	public Ship getEnemyShip() {
		return ship;
	}
	
	public void setLocation(String loc) {
		location = loc;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String encounterAttack() {
		Random r = new Random();
		int random = r.nextInt(4);
		String attack = "";
		if (random == 0) {
			attack = "Enemy ship evaded your attack";
		}
		else {
			attack = "Enemy ship fired their weapon dealing 20 damage";
		}
		return attack;
	}
	
	public void gotAway(Ship player) {
		System.out.println("The enemy ship was able to get away.");
	}
	
	// some sort of display that shows the ship that you have to defeat
	public String toString() {
		return "Enemy ship approaching...\n" + ship + "\nOrbiting... " + location;
	}
	
	
	
} // end Encounter