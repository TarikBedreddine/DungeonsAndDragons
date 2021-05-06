package character;

public abstract class Character {

    // All attributes of Character
    private String name;
    private String image;
    private int life;
    private int attack;
    private String weaponName;
    private int weaponDamage;
    private int characterPosition;
    private int maxLife;
    private int maxAttack;

    //-------------- Constructors ----------------------
    // First constructor, initialize all attributes
    public Character() {
        this.name = "";
        this.image = "";
        this.life = 0;
        this.attack = 0;
        this.weaponName = null;
        this.weaponDamage = 0;
    }

    // Second constructor, initialize all attributes except name which is given by user
    public Character(String selectedName) {
        this();
        this.name = selectedName;
    }

    // Third constructor, all attributes must be given by the user
    public Character(String selectedName, String url, int Life, int Attack, int maxLife, int maxAttack) {
        this();
        this.name = selectedName;
        this.image = url;
        this.life = Life;
        this.attack = Attack;
        this.maxLife = maxLife;
        this.maxAttack = maxAttack;
    }

    // Method to get the name attribute
    public String getName() {
        return this.name;
    }
    // Method to ge the image attribute
    public String getImage() {
        return this.image;
    }

    // Method to get the life attribute
    public int getLife() {
        return this.life;
    }

    // Method to get the attack attribute
    public int getAttack() {
        return this.attack;
    }

    public int getCharacterPosition() {
        return characterPosition;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public String getWeaponName() {
        return weaponName;
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

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    // toString method
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", life=" + life +
                ", attack=" + attack +
                '}';
    }
}
