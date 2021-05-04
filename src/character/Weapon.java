package character;

public class Weapon {
    // Attributes
    private String name;
    private int strength;

    // Constructor
    public Weapon(String weaponName, int weaponStrength) {
        this.name = weaponName;
        this.strength = weaponStrength;
    }

    // Methods

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
}
