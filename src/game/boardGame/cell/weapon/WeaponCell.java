package game.boardGame.cell.weapon;

import character.Character;
import character.Warrior;
import equipment.attackEquipment;
import character.Wizard;
import game.Game;
import game.boardGame.cell.Cell;

public abstract class WeaponCell extends Cell {

    // Attributes
    private String weaponName;
    private int weaponDamage;
    private Character character;
    private attackEquipment attackEquipment;

    // Constructors
    public WeaponCell(String weaponName, int weaponStrength) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponStrength;
        this.attackEquipment = new attackEquipment();
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
            if (attackEquipment.getEquipmentName() == null || (attackEquipment.getEquipmentName() != null && !attackEquipment.getEquipmentName().equals(this.weaponName)) || attackEquipment.getEquipmentDamage() != this.weaponDamage) {
                // Equip the weapon only if it has more damage
                if (attackEquipment.getEquipmentDamage() < this.weaponDamage) {
                    // Set the weapon name & weapon damage to the AttackEquipment Class
                    if (weaponRestriction.equals("Warrior")) {
                        attackEquipment.setType("Weapon");
                    } else {
                        attackEquipment.setType("Spell");
                    }
                    attackEquipment.setEquipmentName(this.weaponName);
                    attackEquipment.setEquipmentDamage(this.weaponDamage);
                    // Update the object attackEquipment in Character Class
                    character.setAttackEquipment(attackEquipment);
                    // If the total attack is > max attack then total attack = max attack
                    if ((attackEquipment.getEquipmentDamage() + character.getAttack()) > character.getMaxAttack()) {
                        attackEquipment.setEquipmentDamage((character.getMaxAttack() - character.getAttack()));
                    }
                    System.out.println("");
                    System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.weaponName + ", elle fait " + attackEquipment.getEquipmentDamage() + " de dégâts.");
                } else {
                    System.out.println("");
                    System.out.println("Vous avez looté " + this.weaponName + " mais elle fait moins de dégâts (" + this.weaponDamage + ") que votre arme actuelle. Vous gardez donc votre arme !");
                }
            } else if (attackEquipment.getEquipmentDamage() == this.weaponDamage && !attackEquipment.getEquipmentName().equals(this.weaponName)) {
                System.out.println("Vous avez looté une arme qui fait les mêmes points de dégâts, Veuillez choisir une des deux armes");
                System.out.println("1 - " + attackEquipment.getEquipmentName() + " (Votre ancienne arme)");
                System.out.println("2 - " + this.weaponName + " (Nouvelle arme)");
                Game g = new Game();
                if (g.changeYourWeapon()) {
                    attackEquipment.setEquipmentName(this.weaponName);
                    attackEquipment.setEquipmentDamage(this.weaponDamage);
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

