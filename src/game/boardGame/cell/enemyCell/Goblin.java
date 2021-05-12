package game.boardGame.cell.enemyCell;

/**
 * Type of a Enemy (Goblin)
 *
 * @author Tarik
 *
 * @see EnemyCell
 * @see game.boardGame.cell.Cell
 */
public class Goblin extends EnemyCell{

    /**
     * Constructor
     * Initialize a Goblin thanks to the parent Constructor
     *
     * {@link EnemyCell#EnemyCell(String, int, int)} (String, int)}
     *
     */
    public Goblin() {
        super("Goblin", 6, 1 );
    }
}
