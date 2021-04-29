package character;

public class Magician {

    // Atributes of a Magician
    private String name;
    private String image;
    private int life;
    private int attack;
    private boolean spell;
    private boolean philtre;

    // Fist constructor, initialize all attributes
    public Magician() {
        this.name = "";
        this.image = "";
        this.life = 3;
        this.attack = 8;
        this.spell = false;
        this.philtre = false;
    }

    // Second constructor, initialize all attributes except name which is given by user
    public Magician(String selectedName) {
        // This constructor call the first constructor to get other attributes
        this();
        this.name = selectedName;

    }

    // Third constructor, all attributes must be given by the user
    public Magician(String selectedName, String url, int magicianLife, int magicianAttack) {
        this.name = selectedName;
        this.image = url;
        this.life = magicianLife ;
        this.attack = magicianAttack;
    }

    public String getName() { return this.name; }

    public int getLife() {
        return this.life;
    }

    public int getAttack() {
        return this.attack;
    }


}
