package game.boardGame.cell.attackEquipment.spell;

/**
 * Type of a spell (FireBall)
 *
 * @author Tarik
 *
 * @see Spell
 * @see game.boardGame.cell.Cell
 *
 */
public class Fireball extends Spell {
    /**
     *
     * Constructor
     * Initialize a spellName and spellDamage thanks to the parent Constructor
     *
     * {@link Spell#Spell(String, int)}
     *
     */
    public Fireball() {
        super("Boule de feu", 7);
    }
}
