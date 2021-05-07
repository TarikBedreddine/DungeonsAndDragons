package character;

public class Wizard extends Character {

    // Attributes of a Wizard
    private String spellName;
    private int spellDamage;
    private boolean philtre;

    // Wizard constructor
    public Wizard() {
        this.spellName = null;
        this.spellDamage = 0;
        this.philtre = false;
    }

    // Access to the First constructor of the parent
    public Wizard(String selectedName) {
        super(selectedName);
    }

    // Access to the Second constructor of the parent
    public Wizard(String selectedName, String url, int WizardLife, int WizardAttack, int maxLife, int maxAttack) {
        super(selectedName, url, WizardLife, WizardAttack, maxLife, maxAttack);
    }

    // Getters & Setters


    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getSpellDamage() {
        return spellDamage;
    }

    public void setSpellDamage(int spellDamage) {
        this.spellDamage = spellDamage;
    }

    public boolean isPhiltre() {
        return philtre;
    }

    public void setPhiltre(boolean philtre) {
        this.philtre = philtre;
    }
}
