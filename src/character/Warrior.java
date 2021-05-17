package character;

/**
 *
 * Warrior is a child of Character
 * Specificities:
 *      minLife = 5
 *      maxLife = 10
 *      minAttack = 5
 *      maxAttack = 10
 *
 * @author Tarik
 *
 * @see Character
 */
public class Warrior extends Character {

    /**
     *
     * First Constructor
     * @deprecated
     *
     */
    public Warrior() {

    }

    /**
     *
     * Access the second Constructor Parent thanks to the method "Super"
     * {@link character.Character#Character(String)}
     *
     * @param selectedName String
     *        Name chosen for the Warrior
     *
     */
    public Warrior(String selectedName) {
        super(selectedName);
    }


    /**
     * Access the third Constructor Parent thanks to the method "Super"
     * {@link character.Character#Character(String, String, int, int, int, int)}
     *
     * @param selectedName String
     * @param url String
     * @param warriorAttack int
     * @param minLife int
     * @param maxLife int
     * @param maxAttack int
     */
    public Warrior(String selectedName, String url, int warriorAttack, int minLife, int maxLife, int maxAttack) {
        super(selectedName, url, warriorAttack, minLife, maxLife, maxAttack);
    }
}

