/**
*Movement.java
*
* This interface can be implemented to allow a ship to move.
*/
public interface Movement {

	/**move
	*	Abstract method the ship will implement.
	*
	*@param solarSystem The solar system in which the ship is moving.
	*@param chosenPlanet The planet the ship will move to.
	*/
	public void move(SolarSystem solarSystem, int chosenPlanet);
}