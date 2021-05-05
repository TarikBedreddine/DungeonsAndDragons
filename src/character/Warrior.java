package character;

import java.lang.reflect.Array;
import java.util.List;

public class Warrior extends Character {

    // Attributes of a Warrior

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

    // Getters & Setters

}

