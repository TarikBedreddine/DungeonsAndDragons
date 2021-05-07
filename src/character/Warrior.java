package character;

public class Warrior extends Character {

    // Attributes of a Warrior
    private String weaponName;
    private int weaponDamage;
    private boolean shield;

    // Warrior constructor
    public Warrior() {
        this.weaponName = null;
        this.weaponDamage = 0;
        this.shield = false;
    }

    // Access to the First constructor of the parent
    public Warrior(String selectedName) {
        super(selectedName);
    }

    // Access to the Second constructor of the parent
    public Warrior(String selectedName, String url, int warriorLife, int warriorAttack, int maxLife, int maxAttack) {
        super(selectedName, url, warriorLife, warriorAttack, maxLife, maxAttack);
    }

    // Getters & Setters

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }
}

