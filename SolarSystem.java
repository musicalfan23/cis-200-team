/**
*SolarSystem.java
*
* This class creates a solarSystem object that has one instance
* arraylist of planet objects. It has methods to get a planet, to get
* the list of planets, and one to remove a planet.
*
*/
import java.util.*;

public class SolarSystem {
    private ArrayList<Planet> planets;

		/**SolarSystem
		* No arg constructor that makes an arraylist of the planets in our solar system.
		*
		*/
    public SolarSystem(){
      planets = new ArrayList<>();
      planets.add(new Planet("Mercury", false, 1));
      planets.add(new Planet("Venus",true , 2));
      planets.add(new Planet("Earth", true, 3));
      planets.add(new Planet("Mars",true, 4));
      planets.add(new Planet("Jupiter",false, 5));
      planets.add(new Planet("Saturn", true, 6));
      planets.add(new Planet("Uranus", false, 7));
      planets.add(new Planet("Neptune", true, 8));
      planets.add(new Planet("Pluto", true, 9));
    }

		/**getPlanet
		* This method returns a planet when given its id number.
		*
		* @param planetNumber The number of the planet to be returned.
		*@return Planet The planet with the id number given.
		*/
    public Planet getPlanet(int planetNumber) {
      return planets.get(planetNumber - 1);
      
    }

		/**removePlanet
		* Sets a planet equal to null when given its id num.
		*
		*@param planetNumber The number of the planet to remove.
		*/
    public void removePlanet(int planetNumber){

      planets.set(planetNumber - 1, null);

    }

		/**getPlanetList
		* This method returns the arraylist of planets.
		*
		*@return planets The arraylist of planets.
		*/
    public ArrayList<Planet> getPlanetsList(){
      return planets;
    }
    

}