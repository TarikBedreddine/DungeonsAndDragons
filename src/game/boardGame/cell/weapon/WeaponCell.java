package game.boardGame.cell.weapon;

import character.Character;
import character.Warrior;
import character.Weapon;
import character.Wizard;
import game.Game;
import game.boardGame.cell.Cell;

public abstract class WeaponCell extends Cell {

    // Attributes
    private String weaponName;
    private int weaponDamage;
    private Character character;
    private Weapon weapon;

    // Constructors
    public WeaponCell(String weaponName, int weaponStrength) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponStrength;
        this.weapon = new Weapon();
    }

    // Methods
    public String weaponRestriction(Character character) {
        if ((this.weaponName.equals("Epée") || this.weaponName.equals("Massue")) && (character instanceof Warrior)) {
            return "Warrior";
        } else if ((this.weaponName.equals("Boule de feu") || this.weaponName.equals("Eclair")) && (character instanceof Wizard)) {
            return "Wizard";
        } else if (character instanceof Warrior) {
            System.out.println(" ");
            System.out.println("Vous avez trouvé un équipement : "+ this.weaponName);
            System.out.println("Mais vous ne pouvez pas équiper cet équipement pour un Guerrier");
            return "WarriorFail";
        }
        System.out.println(" ");
        System.out.println("Vous avez trouvé un équipement : "+ this.weaponName);
        System.out.println("Mais vous ne pouvez pas équiper cet équipement pour un Magicien");
        return "WizardFail";
    }

    @Override
    public void interaction(Character character) {
        String weaponRestriction = weaponRestriction(character);
        if (weaponRestriction.equals("Warrior") || weaponRestriction.equals("Wizard")) {
            if (weapon.getWeaponName() == null || (weapon.getWeaponName() != null && !weapon.getWeaponName().equals(this.weaponName)) || weapon.getWeaponDamage() != this.weaponDamage) {
                if (weapon.getWeaponDamage() < this.weaponDamage) {
                    // Set the weapon name & weapon damage to the character
                    weapon.setWeaponName(this.weaponName);
                    weapon.setWeaponDamage(this.weaponDamage);
                    // If the total attack is > max attack then total attack = max attack
                    if ((weapon.getWeaponDamage() + character.getAttack()) > character.getMaxAttack()) {
                        weapon.setWeaponDamage((character.getMaxAttack() - character.getAttack()));
                    }
                    System.out.println("");
                    System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.weaponName + ", elle fait " + weapon.getWeaponDamage() + " de dégâts.");
                } else {
                    System.out.println("");
                    System.out.println("Vous avez looté " + this.weaponName + " mais elle fait moins de dégâts (" + this.weaponDamage + ") que votre arme actuelle. Vous gardez donc votre arme !");
                }
            } else if (weapon.getWeaponDamage() == this.weaponDamage && !weapon.getWeaponName().equals(this.weaponName)) {
                System.out.println("Vous avez looté une arme qui fait les mêmes points de dégâts, Veuillez choisir une des deux armes");
                System.out.println("1 - " + weapon.getWeaponName() + " (Votre ancienne arme)");
                System.out.println("2 - " + this.weaponName + " (Nouvelle arme)");
                Game g = new Game();
                if (g.changeYourWeapon()) {
                    weapon.setWeaponName(this.weaponName);
                    weapon.setWeaponDamage(this.weaponDamage);
                }
            } else {
                System.out.println("");
                System.out.println("Vous avez déjà looté " + this.weaponName);
            }
        }
    }


    // Getters & Setters

    @Override
    public String toString() {
        return "WeaponCell{" +
                "weaponName='" + weaponName + '\'' +
                ", weaponDamage=" + weaponDamage +
                '}';
    }
}

