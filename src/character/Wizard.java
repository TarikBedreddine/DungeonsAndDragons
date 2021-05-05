package character;

public class Wizard extends Character {

    // Attributes of a Wizard
    private String spell;
    private String philtre;

    // Wizard constructor
    public Wizard() {

    }

    // Access to the First constructor of the parent
    public Wizard(String selectedName) {
        super(selectedName);
    }

    // Access to the Second constructor of the parent
    public Wizard(String selectedName, String url, int WizardLife, int WizardAttack, int maxLife, int maxAttack) {
        super(selectedName, url, WizardLife, WizardAttack, maxLife, maxAttack);
    }

    // Method to get the parent name attribute
    public String name() {
        return getName();
    }

    // Method to get the parent image attribute
    public String image() {
        return getImage();
    }

    // Method to get the parent life attribute
    public int life() {
        return getLife();
    }

    // Method to get the parent attack attribute
    public int attack() {
        return getAttack();
    }
}
