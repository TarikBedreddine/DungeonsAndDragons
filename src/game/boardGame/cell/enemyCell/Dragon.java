package game.boardGame.cell.enemyCell;

/**
 * Type of a Enemy (Dragon)
 *
 * @author Tarik
 *
 * @see EnemyCell
 * @see game.boardGame.cell.Cell
 */
public class Dragon extends EnemyCell{

    /**
     * Constructor
     * Initialize a Dragon thanks to the parent Constructor
     *
     * {@link EnemyCell#EnemyCell(String, int, int)} (String, int)}
     *
     */
    public Dragon() {
        super("Dragon", 15, 4);
    }

}
