package game.boardGame.cell.attackEquipment.weapon;

import character.Character;
import character.Warrior;
import game.Game;
import game.boardGame.cell.attackEquipment.AttackEquipment;
import stuff.Stuff;

/**
 * The Class is dedicated for Warrior.
 * It handle Fireball & Thunderbolt interaction with the character
 *
 *
 * @see AttackEquipment
 * @see Club
 * @see Sword
 */
public class Weapon extends AttackEquipment {

    // Attributes
    private String weaponName;
    private int weaponDamage;

    /**
     * Constructor
     * Retrieve data given by child constructor and initialize attributes
     *
     * @param weaponName String
     *      Name of the Weapon
     * @param weaponStrength int
     *      Damage can cause the Weapon to the character
     *
     * {@link Club#Club()}
     * {@link Sword#Sword()}
     *
     */
    public Weapon(String weaponName, int weaponStrength) {
        this.weaponName=  weaponName;
        this.weaponDamage = weaponStrength;
    }

    /**
     * This method set all actions between the item and the character
     * It has 3 main features :
     *      - Equip a Weapon (Thunderbolt or FireBall)
     *      - Equip a Weapon only if damage > currentSpell
     *      - Choose between 2 weapons with the same Damage
     *      - Equip the spell only for Warrior
     *
     *
     * @param character Character
     *      Character to deal with the interaction
     *
     */
    @Override
    public void interaction(Character character, Stuff stuff) {
        if (character instanceof Warrior) {
           AttackEquipment currentWeapon = character.getAttackEquipment();
            if (currentWeapon == null || (currentWeapon.getEquipmentName() != null && !currentWeapon.getEquipmentName().equals(this.weaponName))) {
                // Equip the weapon only if it has more damage
                if (currentWeapon == null) {
                    character.setAttackEquipment(this);
                    currentWeapon = character.getAttackEquipment();

                    // If the total attack is > max attack then total attack = max attack
                    if ((currentWeapon.getEquipmentDamage() + character.getAttack()) > character.getMaxAttack()) {
                        currentWeapon.setEquipmentDamage((character.getMaxAttack() - character.getAttack()));
                    }
                    System.out.println("");
                    System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.weaponName + ", elle fait " + this.weaponDamage + " de dégâts.");
                } else if (currentWeapon.getEquipmentDamage() < this.weaponDamage) {
                    System.out.println("");
                    System.out.println("Vous avez looté " + this.weaponName + " mais elle fait moins de dégâts (" + this.weaponDamage + ") que votre arme actuelle. Vous gardez donc votre arme !");
                }
            }  else {
                System.out.println("");
                System.out.println("Vous avez déjà looté " + this.weaponName);
            }
        } else {
            System.out.println("");
            System.out.println("Vous êtes un magicien, vous ne pouvez pas équiper cette arme (" +this.weaponName+")");
        }
    }

    /**
     * Return a string of all attributes value
     * @return String
     *
     */
    @Override
    public String toString() {
        return "Weapon{" +
                "weaponName='" + weaponName + '\'' +
                ", weaponDamage=" + weaponDamage +
                '}';
    }
}

