package character;

import game.boardGame.cell.attackEquipment.AttackEquipment;

/**
 *
 * Abstract Parent Class that permit to create characters
 *
 * It contains these attributes
 *      - A Name : name of the character
 *      - An image : url of the character image
 *      - A life / attack : life and attack integers
 *      - characterPosition : position in the boardGame
 *      - attackEquipment : it can be weapon or a spell
 *      - Min & Max Life : min & max value of life
 *      - Max Attack : max attack for the character
 *
 * User can create two characters Warrior & Wizard
 * @see Warrior
 * @see Wizard
 *
 * More information about equipment :
 * @see AttackEquipment
 *
 */
public abstract class Character {

    // All attributes of Character
    private String name;
    private String image;
    private int life;
    private int attack;
    private int characterPosition;
    private AttackEquipment attackEquipment;
    private int minLife;
    private int maxLife;
    private int maxAttack;

    /**
     *
     * First Constructor
     *      Initialize all mandatory attributes & equipment Object
     */
    public Character() {
        this.name = "";
        this.image = "";
        this.life = 0;
        this.attack = 0;
        this.attackEquipment = null;
    }

    /**
     * Second Constructor
     *
     * @param selectedName String
     *      Set the name chosen
     */
    public Character(String selectedName) {
        this();
        this.name = selectedName;
    }

    /**
     *
     * Third Constructor
     * Thanks to the params, user can create his own character
     *
     * this() refer to the first constructor to initialize an attribute that i don't deal with in these constructor
     *
     * @param selectedName String
     *        Name of the character (Alphanumeric allowed)
     * @param url String
     *        Set an image for the character
     * @param Attack int
     *        Current character attack
     * @param minLife int
     * @param maxLife int
     *        minLife & maxLife are necessary during fights
     * @param maxAttack int
     *        define the maxAttack for the Character
     */
    public Character(String selectedName, String url, int Attack, int minLife, int maxLife, int maxAttack) {
        this();
        this.name = selectedName;
        this.image = url;
        this.life = minLife;
        this.attack = Attack;
        this.minLife = minLife;
        this.maxLife = maxLife;
        this.maxAttack = maxAttack;
    }


    public int getTotalAttack() {
        if (attackEquipment != null) {
            return attack + attackEquipment.getEquipmentDamage();
        }
        return attack;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public int getLife() {
        return this.life;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getCharacterPosition() {
        return characterPosition;
    }

    public int getMinLife() {
        return minLife;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public AttackEquipment getAttackEquipment() {
        return attackEquipment;
    }

    // Setters
    public void setName(String newName) {
        this.name = newName;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setCharacterPosition(int characterPosition) {

        this.characterPosition += characterPosition;
    }

    public void setAttackEquipment(AttackEquipment attackEquipment) {
        this.attackEquipment = attackEquipment;
    }


    /**
     *
     * @return String
     *        Return a String with the value of each attribute
     */
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", life=" + life +
                ", attack=" + attack +
                ", characterPosition=" + characterPosition +
                ", minLife=" + minLife +
                ", maxLife=" + maxLife +
                ", maxAttack=" + maxAttack +
                ", attackEquipment=" + attackEquipment +
                '}';
    }
}
