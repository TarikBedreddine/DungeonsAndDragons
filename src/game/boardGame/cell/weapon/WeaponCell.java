package game.boardGame.cell.weapon;

import character.Character;
import game.Game;
import game.boardGame.cell.Cell;

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
        if (character.getWeaponName() == null || (character.getWeaponName() != null && !character.getWeaponName().equals(this.weaponName)) || character.getWeaponDamage() != this.weaponDamage) {
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
        } else if (character.getWeaponDamage() == this.weaponDamage && !character.getWeaponName().equals(this.weaponName)) {
            System.out.println("Vous avez looté une arme qui fait les mêmes points de dégâts, Veuillez choisir une des deux armes");
            System.out.println("1 - " + character.getWeaponName() + " (Votre ancienne arme)");
            System.out.println("2 - " + this.weaponName + " (Nouvelle arme)");
            Game g = new Game();
            if (g.changeYourWeapon()) {
                character.setWeaponName(this.weaponName);
                character.setWeaponDamage(this.weaponDamage);
            }
        } else {
            System.out.println("");
            System.out.println("Vous avez déjà looté " + this.weaponName);
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

