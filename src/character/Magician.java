package character;

public class Magician {
    private String name;
    private String image;
    private int life = 3;
    private int attack = 8;
    private boolean spell = false;
    private boolean philtre = false;

    public Magician() {
        name = "";
    }

    public Magician(String selectedName) {
        name = selectedName;

    }

    public Magician(String selectedName, String url, int magicianLife, int magicianAttack) {
        name = selectedName;
        image = url;
        life = magicianLife ;
        attack = magicianAttack;
    }
}
