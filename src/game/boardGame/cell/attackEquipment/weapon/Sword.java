package game.boardGame.cell.attackEquipment.weapon;


import game.boardGame.cell.attackEquipment.spell.Spell;

/**
 * Type of a Weapon (Sword)
 *
 * @author Tarik
 *
 * @see Spell
 * @see game.boardGame.cell.Cell
 *
 */
public class Sword extends Weapon {

    /**
     * Constructor
     * Initialize a weaponName and weaponDamage thanks to the parent Constructor
     *
     * {@link Weapon#Weapon(String, int)}
     *
     */
    public Sword() {
        super("Epée", 5);
    }
}
