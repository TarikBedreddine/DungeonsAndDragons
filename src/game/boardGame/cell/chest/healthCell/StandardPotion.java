package game.boardGame.cell.chest.healthCell;

/**
 * Type of a spell (FireBall)
 *
 * @author Tarik
 *
 * @see HealthCell
 * @see game.boardGame.cell.Cell
 *
 */
public class StandardPotion extends HealthCell {

    /**
     * Constructor
     * Initialize a shieldName and lifeRescue thanks to the parent Constructor
     *
     * {@link HealthCell(String, int)}
     *
     */
    public StandardPotion() {
        super("Potion standard", 2);
    }
}
