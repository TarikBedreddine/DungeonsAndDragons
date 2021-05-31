package game.boardGame.cell.attackEquipment.spell;

import character.Character;
import character.Wizard;
import game.Game;
import game.boardGame.cell.attackEquipment.AttackEquipment;
import menu.Navigation;
import stuff.Stuff;

import java.util.ArrayList;

/**
 * The Class is dedicated for Wizard.
 * It handle Fireball & Thunderbolt interaction with the character
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
     * Constructor
     * Retrieve data given by child constructor and initialize attributes
     *
     * @param spellName   String
     *                    Name of the Spell
     * @param spellDamage int
     *                    Damage can cause the spell to the character
     *                    <p>
     *                    {@link Thunderbolt#Thunderbolt()}
     *                    {@link Fireball#Fireball()}
     */
    public Spell(String spellName, int spellDamage) {
        super(spellName, spellDamage);
        this.spellName = spellName;
        this.spellDamage = spellDamage;
    }

    /**
     * This method set all actions between the item and the character
     * It has 3 main features :
     * - Equip a spell (Thunderbolt or FireBall)
     * - Equip a spell only if damage > currentSpell
     * - Choose between 2 weapons with the same Damage
     * - Equip the spell only for Wizard
     *
     * @param character Character
     *                  Character to deal with the interaction
     * @param stuff
     */
    @Override
    public void interaction(Character character, Stuff stuff) {
        AttackEquipment currentWeapon = character.getAttackEquipment();
        if (character instanceof Wizard) {
            if (currentWeapon == null) {
                character.setAttackEquipment(new Spell(this.spellName, this.spellDamage));
                System.out.println("");
                System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.spellName + ", elle fait " + this.spellDamage + " de dégâts.");

            } else if ((!currentWeapon.getEquipmentName().equals(this.spellName))) {
                // Equip the weapon only if it has more damage
                if (currentWeapon.getEquipmentDamage() < this.spellDamage) {
                    character.setAttackEquipment(new Spell(this.spellName, this.spellDamage));

                    // If the total attack is > max attack then total attack = max attack
                    if ((currentWeapon.getEquipmentDamage() + character.getAttack()) > character.getMaxAttack()) {
                        currentWeapon.setEquipmentDamage((character.getMaxAttack() - character.getAttack()));
                    }
                    System.out.println("");
                    System.out.println("Vous êtes maintenant équipé de l'arme suivante : " + this.spellName + ", elle fait " + this.spellDamage + " de dégâts.");
                } else {
                    Navigation nav = new Navigation();
                    ArrayList<String> questions = new ArrayList<>();
                    questions.add("Vous avez looté "+spellName+" il fait moins de dégâts ("+spellDamage+"), voulez vous le stocker dans votre inventaire ?");
                    questions.add("1 - OUI");
                    questions.add("2 - NON");
                    if (nav.askQuestion(questions) == 1) {
                        stuff.addItemToBackpack(this, this.spellName);
                    }
                }
            } else {
                System.out.println("");
                System.out.println("Vous avez déjà looté " + this.spellName);
            }
        } else {
            System.out.println("");
            System.out.println("Vous êtes un Guerrier, vous ne pouvez pas équiper ce sort (" + this.spellName + ")");
        }
    }


    /**
     * Return a string of all attributes value
     *
     * @return String
     */
    @Override
    public String toString() {
        return  spellName + " inflige " + spellDamage+ " de dégâts";
    }
}
