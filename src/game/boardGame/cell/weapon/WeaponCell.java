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
        if (character.getWeaponName() == null || (character.getWeaponName() != null && !character.getWeaponName().equals(this.weaponName))) {
            if (character.getWeaponDamage() < this.weaponDamage) {
                // Set the weapon name & weapon damage to the character
                character.setWeaponName(this.weaponName);
                character.setWeaponDamage(this.weaponDamage);
                // If the total attack is > max attack then total attack = max attack
                if ((character.getWeaponDamage() + character.getAttack()) > character.getMaxAttack()) {
                    character.setWeaponDamage((character.getMaxAttack() - character.getAttack()));
                }
                System.out.println("");
                System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.weaponName + ", elle fait " + character.getWeaponDamage() + " de dégâts.");
            } else {
                System.out.println("");
                System.out.println("Vous avez looté " + this.weaponName + " mais elle fait moins de dégâts (" + this.weaponDamage + ") que votre arme actuelle. Vous gardez donc votre arme !");
            }
        } else {
            System.out.println("");
            System.out.println("Vous avez looté " + this.weaponName + " mais vous l'avez déjà, dommage !");
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

