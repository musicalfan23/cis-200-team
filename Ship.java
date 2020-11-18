import java.awt.event.KeyEvent;

public class Ship extends Sprite{
    private int dx;
    private int dy;

    private int hp;
    private int shieldNum;
    private String shieldType;
    private double maxSpeed;
    private double currentSpeed;
    private double fuelLeft;
    private double maxFuel;
    private Weapon weapon;

    public Ship(int x, int y, double fuelTank){
        super(x, y);
        maxFuel = fuelTank;
    }

    public int getHP(){
        return hp;
    }

    public void takeDamage(int hp){
        this.hp -= hp;
    }

    public void useFuel(double fuel){
        this.fuelLeft -= fuel;
    }

    public void refuel(double fuel){
        if(this.fuelLeft + fuel < maxFuel){
            this.fuelLeft += fuel;
        }else{
            this.fuelLeft = maxFuel;
        }
        
    }

    public void changeWeapon(Weapon newWeapon){
        weapon = newWeapon;
    }

    public double getSpeed(){
        return currentSpeed;
    }

    public double getFuel(){
        return fuelLeft;
    }

    public void move(){
        
    }

    //Sprite Movement
/*
    public void move(){
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE){
            weapon.fireWeapon(new Ship(10,10,10));

        }
        if(key == KeyEvent.VK_LEFT){
            dx = -1;
        }
        if(key == KeyEvent.VK_RIGHT){
            dx = 1;
        }
        if(key == KeyEvent.VK_UP){
            dy = -1;
        }
        if(key == KeyEvent.VK_DOWN){
            dy = 1;
        }
    }
*/

}
