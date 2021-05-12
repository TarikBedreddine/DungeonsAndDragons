package game.boardGame.cell.attackEquipment.weapon;


import game.boardGame.cell.attackEquipment.spell.Spell;

/**
 * Type of a Weapon (Club)
 *
 * @author Tarik
 *
 * @see Spell
 * @see game.boardGame.cell.Cell
 *
 */
public class Club extends Weapon {

    /**
     * Constructor
     * Initialize a weaponName and weaponDamage thanks to the parent Constructor
     *
     * {@link Weapon#Weapon(String, int)}
     *
     */
    public Club() {
        super("Massue", 3);
    }
}
