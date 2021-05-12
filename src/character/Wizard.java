package character;

/**
 *
 * Wizard is a child of Character
 * Specificities:
 *      minLife = 3
 *      maxLife = 6
 *      minAttack = 8
 *      maxAttack = 15
 *
 * @author Tarik
 *
 * @see Character
 */
public class Wizard extends Character {

    /**
     *
     * First Constructor
     * @deprecated
     *
     */
    public Wizard() {

    }


    /**
     *
     * Access the second Constructor Parent thanks to the method "Super"
     * {@link character.Character#Character(String)}
     *
     * @param selectedName String
     *        Name chosen for the Wizard
     *
     */
    public Wizard(String selectedName) {
        super(selectedName);
    }


    /**
     * Access the third Constructor Parent thanks to the method "Super"
     * {@link character.Character#Character(String, String, int, int, int, int, int)}
     *
     * @param selectedName String
     * @param url String
     * @param wizardLife int
     * @param wizardAttack int
     * @param minLife int
     * @param maxLife int
     * @param maxAttack int
     */
    public Wizard(String selectedName, String url, int wizardLife, int wizardAttack, int minLife, int maxLife, int maxAttack) {
        super(selectedName, url, wizardLife, wizardAttack, minLife, maxLife, maxAttack);
    }

}
