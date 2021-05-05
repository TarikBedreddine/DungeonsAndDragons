package game.boardGame.cell.weapon;
import character.Character;
import game.boardGame.cell.Cell;

public abstract class Weapon extends Cell {

    // Attributes
    private String name;
    private int strength;

    // Constructors
    public Weapon(String weaponName, int weaponStrength) {
        this.name = weaponName;
        this.strength = weaponStrength;
        System.out.println(toString());
    }

    // Methods
    @Override
    public void interaction(Character character) {

    }

    // Getters & Setters
    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                '}';
    }
}

