public class Weapon {
	
	String weaponType;
	double damage;
	int ammoRemaining;
	
	
	public Weapon(String wT, double d, int aR) {
		weaponType = wT;
		damage = d;
		ammoRemaining = aR;
	}
	
	public double fireWeapon(Ship target) {
		target.takeDamage(damage);
		ammoRemaining--;
	}
	
	public String getWeaponType() {
		return weaponType;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public int getAmmoRemaining() {
		return ammoRemaining;
	}
	
	public void setWeaponType(String wT) {
		weaponType = wT;
	}
	
	public void setDamage(Double d) {
		damage = d;
	}
	
	public void setAmmoRemaining(int aR) {
		ammoRemaining = aR;
	}
}