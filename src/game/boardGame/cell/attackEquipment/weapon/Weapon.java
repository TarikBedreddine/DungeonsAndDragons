package game.boardGame.cell.attackEquipment.weapon;

import character.Character;
import character.Warrior;
import character.Wizard;
import game.Game;
import game.boardGame.cell.attackEquipment.AttackEquipment;
import menu.Navigation;
import stuff.Stuff;

import java.util.ArrayList;

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
    private final String weaponName;
    private final int weaponDamage;

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
        super(weaponName, weaponStrength);
        this.weaponName = weaponName;
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
        AttackEquipment currentWeapon = character.getAttackEquipment();
        if (character instanceof Warrior) {
            if (currentWeapon == null) {
                character.setAttackEquipment(new Weapon(this.weaponName, this.weaponDamage));
                System.out.println("");
                System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.weaponName + ", elle fait " + this.weaponDamage + " de dégâts.");

            } else if ((!currentWeapon.getEquipmentName().equals(this.weaponName))) {
                // Equip the weapon only if it has more damage
                if (currentWeapon.getEquipmentDamage() < this.weaponDamage) {
                    character.setAttackEquipment(new Weapon(this.weaponName, this.weaponDamage));

                    // If the total attack is > max attack then total attack = max attack
                    if ((currentWeapon.getEquipmentDamage() + character.getAttack()) > character.getMaxAttack()) {
                        currentWeapon.setEquipmentDamage((character.getMaxAttack() - character.getAttack()));
                    }
                    System.out.println("");
                    System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.weaponName + ", elle fait " + this.weaponDamage + " de dégâts.");
                }
            } else if (currentWeapon.getEquipmentDamage() < this.weaponDamage) {
                Navigation nav = new Navigation();
                ArrayList<String> questions = new ArrayList<>();
                questions.add("Vous avez looté "+weaponName+" elle fait moins de dégâts ("+weaponDamage+"), voulez vous le stocker dans votre inventaire ?");

                questions.add("1 - OUI");
                questions.add("2 - NON");
                if (nav.askQuestion(questions) == 1) {
                    stuff.addItemToBackpack(this, this.weaponName);
                }
            }
        } else {
            System.out.println("");
            System.out.println("Vous êtes un Magicien, vous ne pouvez pas équiper ce sort (" + this.weaponName + ")");
        }
    }

    /**
     * Return a string of all attributes value
     * @return String
     *
     */
    @Override
    public String toString() {
        return weaponName + " inflige " + weaponDamage+ " de dégâts";
    }
}

