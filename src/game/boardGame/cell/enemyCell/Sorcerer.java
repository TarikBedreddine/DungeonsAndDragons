package game.boardGame.cell.enemyCell;

/**
 * Type of a Enemy (Sorcerer)
 *
 * @author Tarik
 *
 * @see EnemyCell
 * @see game.boardGame.cell.Cell
 */
public class Sorcerer extends EnemyCell{

    /**
     * Constructor
     * Initialize a Sorcerer thanks to the parent Constructor
     *
     * {@link EnemyCell#EnemyCell(String, int, int)} (String, int)}
     *
     */
    public Sorcerer() {
        super("Sorcier", 9, 2);
    }
}
