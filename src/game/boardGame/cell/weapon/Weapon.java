package game.boardGame.cell.weapon;

import game.boardGame.cell.Cell;

public abstract class Weapon extends Cell {

    // Attributes
    private String name;
    private int strenght;

    // Constructors
    public Weapon() {}

    public Weapon(String weaponName, int weaponStrenght) {
        cellFocused();
        this.name = weaponName;
        this.strenght = weaponStrenght;
        System.out.println(toString());
    }

    // Methods
    @Override
    public void cellFocused() {

    }

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

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", strenght=" + strenght +
                '}';
    }
}

