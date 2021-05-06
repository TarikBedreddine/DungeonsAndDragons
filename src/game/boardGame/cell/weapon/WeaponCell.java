package game.boardGame.cell.weapon;
import character.Character;
import character.Warrior;
import character.Wizard;
import game.boardGame.cell.Cell;
import sun.text.normalizer.UCharacter;

public abstract class WeaponCell extends Cell {

    // Attributes
    private String weaponName;
    private int weaponDamage;

    // Constructors
    public WeaponCell(String weaponName, int weaponStrength) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponStrength;
    }

    // Methods
    @Override
    public void interaction(Character character) {
        if (character.getWeaponDamage() < this.weaponDamage) {
            character.setWeaponName(this.weaponName);
            character.setWeaponDamage(this.weaponDamage);
            System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.weaponName + " elle fait " + character.getWeaponDamage() + " de dégâts");
            System.out.println(character.toString());
        } else {
            System.out.println("Vous avez looté " + this.weaponName + " mais elle fait moins de dégâts (" + this.weaponDamage +") que votre arme actuelle. Vous gardez donc votre arme !");
        }
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

    @Override
    public String toString() {
        return "WeaponCell{" +
                "weaponName='" + weaponName + '\'' +
                ", weaponDamage=" + weaponDamage +
                '}';
    }
}

