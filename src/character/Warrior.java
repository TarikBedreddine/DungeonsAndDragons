package character;

import java.lang.reflect.Array;
import java.util.List;

public class Warrior extends Character {

    // Attributes of a Warrior
    private String weapon;
    private String shield;

    // Warrior constructor
    public Warrior() {

    }

    // Access to the First constructor of the parent
    public Warrior(String selectedName) {
        super(selectedName);
    }

    // Access to the Second constructor of the parent
    public Warrior(String selectedName, String url, int warriorLife, int warriorAttack, int maxLife, int maxAttack) {
        super(selectedName, url, warriorLife, warriorAttack, maxLife, maxAttack);
    }

    // Method to get the parent name attribute
    public String name() {
        return getName();
    }

    // Method to get the parent image attribute
    public String image() {
        return getImage();
    }

    // Method to get the parent life attribute
    public int life() {
        return getLife();
    }

    // Method to get the parent attack attribute
    public int attack() {
        return getAttack();
    }
}

