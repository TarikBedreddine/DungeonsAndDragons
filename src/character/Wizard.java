package character;

public class Wizard extends Character {

    // Attributes of a Wizard

    // Wizard constructor
    public Wizard() {

    }

    // Access to the First constructor of the parent
    public Wizard(String selectedName) {
        super(selectedName);
    }

    // Access to the Second constructor of the parent
    public Wizard(String selectedName, String url, int WizardLife, int wizardAttack, int minLife, int maxLife, int maxAttack) {
        super(selectedName, url, WizardLife, wizardAttack, minLife, maxLife, maxAttack);
    }

    // Getters & Setters

}
