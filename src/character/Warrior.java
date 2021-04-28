package character;

public class Warrior {

    // Attributes of a Warrior
    private String name;
    private String image;
    private int life = 5;
    private int attack = 5;
    private boolean weapon = false;
    private boolean sheild = false;

    public Warrior() {
        name = "";
    }

    public Warrior(String selectedName) {
        name = selectedName;
    }

    public Warrior(String selectedName, String url, int warriorLife, int warriorAttack) {
        name = selectedName;
        image = url;
        life = warriorLife;
        attack = warriorAttack;
    }


}
