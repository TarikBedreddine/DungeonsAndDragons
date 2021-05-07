package character;

public class Weapon {

    // Attributes
    private String weaponName;
    private int weaponDamage;

    // Constructors
    public Weapon() {
        this.weaponName = "";
        this.weaponDamage = 0;
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
}
