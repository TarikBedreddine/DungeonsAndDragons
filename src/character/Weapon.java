package character;

public class Weapon {
    // Attributes
    private String name;
    private int strenght;

    // Constructor
    public Weapon(String weaponName, int weaponStrenght) {
        this.name = weaponName;
        this.strenght = weaponStrenght;
    }

    // Methods

    // Getters & Setters
    public int getStrenght() {
        return strenght;
    }

    public String getName() {
        return name;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public void setName(String name) {
        this.name = name;
    }
}
