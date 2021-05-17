package game.boardGame.cell.attackEquipment.spell;

import character.Character;
import character.Warrior;
import character.Wizard;
import game.Game;
import game.boardGame.cell.Cell;
import game.boardGame.cell.attackEquipment.AttackEquipment;

/**
 *
 * The Class is dedicated for Wizard.
 * It handle Fireball & Thunderbolt interaction with the character
 *
 *
 * @see AttackEquipment
 * @see Fireball
 * @see Thunderbolt
 */
public class Spell extends AttackEquipment {

    // Attributes
    private String spellName;
    private int spellDamage;

    /**
     *
     * Constructor
     * Retrieve data given by child constructor and initialize attributes
     *
     * @param spellName String
     *      Name of the Spell
     * @param spellDamage int
     *      Damage can cause the spell to the character
     *
     * {@link Thunderbolt#Thunderbolt()}
     * {@link Fireball#Fireball()}
     *
     */
    public Spell(String spellName, int spellDamage) {
        this.spellName = spellName;
        this.spellDamage = spellDamage;
    }

    /**
     *
     * This method set all actions between the item and the character
     * It has 3 main features :
     *      - Equip a spell (Thunderbolt or FireBall)
     *      - Equip a spell only if damage > currentSpell
     *      - Choose between 2 weapons with the same Damage
     *      - Equip the spell only for Wizard
     *
     *
     * @param character Character
     *      Character to deal with the interaction
     *
     */
    @Override
    public void interaction(Character character) {
        if (character instanceof Wizard) {
            AttackEquipment currentWeapon = character.getAttackEquipment();
            if (currentWeapon.getEquipmentName() == null || (currentWeapon.getEquipmentName() != null && !currentWeapon.getEquipmentName().equals(this.spellName)) || currentWeapon.getEquipmentDamage() != this.spellDamage) {
                // Equip the weapon only if it has more damage
                if (currentWeapon.getEquipmentDamage() < this.spellDamage) {
                    currentWeapon.setEquipmentName(this.spellName);
                    currentWeapon.setEquipmentDamage(this.spellDamage);

                    // If the total attack is > max attack then total attack = max attack
                    if ((currentWeapon.getEquipmentDamage() + character.getAttack()) > character.getMaxAttack()) {
                        currentWeapon.setEquipmentDamage((character.getMaxAttack() - character.getAttack()));
                    }
                    System.out.println("");
                    System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.spellName + ", elle fait " + currentWeapon.getEquipmentDamage() + " de dégâts.");
                } else {
                    System.out.println("");
                    System.out.println("Vous avez looté " + this.spellName + " mais il fait moins de dégâts (" + this.spellDamage + ") que votre sort actuel. Vous gardez donc votre sort !");
                }
            } else if (currentWeapon.getEquipmentDamage() == this.spellDamage && !currentWeapon.getEquipmentName().equals(this.spellName)) {
                System.out.println("Vous avez looté un sort qui fait les mêmes points de dégâts, Veuillez choisir un des deux sort");
                System.out.println("1 - " + currentWeapon.getEquipmentName() + " (Votre ancien sort)");
                System.out.println("2 - " + this.spellName + " (Nouveau sort)");
                Game g = new Game();
                if (g.changeYourWeapon()) {
                    currentWeapon.setEquipmentName(this.spellName);
                    currentWeapon.setEquipmentDamage(this.spellDamage);
                }
            } else {
                System.out.println("");
                System.out.println("Vous avez déjà looté " + this.spellName);
            }
        } else {
            System.out.println("");
            System.out.println("Vous êtes un Guerrier, vous ne pouvez pas équiper ce sort (" +this.spellName+")");
        }
    }

    /**
     *
     * Return a string of all attributes value
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Spell{" +
                "spellName='" + spellName + '\'' +
                ", spellDamage=" + spellDamage +
                '}';
    }
}
