package character;

import java.lang.reflect.Array;
import java.util.List;

public class Warrior {

    // Attributes of a Warrior
    private String name;
    private String image;
    private int life;
    private int attack;
    private boolean weapon;
    private boolean shield;

    // Fist constructor, initialize all attributes
    public Warrior() {
        this.name = "";
        this.image = "";
        this.life = 5;
        this.attack = 5;
        this.weapon = false;
        this.shield = false;
    }

    // Second constructor, initialize all attributes except name which is given by user
    public Warrior(String selectedName) {
        this();
        this.name = selectedName;
    }

    // Third constructor, all attributes must be given by the user
    public Warrior(String selectedName, String url, int warriorLife, int warriorAttack) {
        this.name = selectedName;
        this.image = url;
        this.life = warriorLife;
        this.attack = warriorAttack;
        this.weapon = false;
        this.shield = false;
    }

    // Method to get the name attribute
    public String getName() {
        return this.name;
    }

    // Method to get the life attribute
    public int getLife() {
        return this.life;
    }

    // Method to get the attack attribute
    public int getAttack() {
        return this.attack;
    }

}

