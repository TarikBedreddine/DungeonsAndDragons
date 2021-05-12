package game.boardGame.cell.attackEquipment.spell;

/**
 *
 * Type of a spell (Thunderbolt)
 *
 * @author Tarik
 *
 * @see Spell
 * @see game.boardGame.cell.Cell
 *
 */
public class Thunderbolt extends Spell {
    /**
     *
     * Constructor
     * Initialize a spellName and spellDamage thanks to the parent Constructor
     *
     * {@link Spell#Spell(String, int)}
     *
     */
    public Thunderbolt() {
        super("Eclair", 2);
    }
}
