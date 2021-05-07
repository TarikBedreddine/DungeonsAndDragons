package character;

public abstract class Character {

    // All attributes of Character
    private String name;
    private String image;
    private int life;
    private int attack;
    private int characterPosition;
    private Weapon weapon;
    //private Defense defense;
    private int maxLife;
    private int maxAttack;

    //-------------- Constructors ----------------------
    // First constructor, initialize all attributes
    public Character() {
        this.name = "";
        this.image = "";
        this.life = 0;
        this.attack = 0;
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

    public int getMaxLife() {
        return maxLife;
    }

    public int getMaxAttack() {
        return maxAttack;
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

    // toString method

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", life=" + life +
                ", attack=" + attack +
                ", characterPosition=" + characterPosition +
                ", maxLife=" + maxLife +
                ", maxAttack=" + maxAttack +
                '}';
    }
}
