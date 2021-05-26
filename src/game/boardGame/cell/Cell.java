package game.boardGame.cell;
import character.Character;

/**
 * Represent a Cell of the BoardGame
 * Implement an abstract method interaction that will used by children
 *
 * @author Tarik
 *
 * @see game.boardGame.BoardGame
 *
 */
public interface Cell {

    /**
     * Abstract method to interact with the Cells
     *
     * @param character Character
     *      Character who will interact with Cell
     */
    void interaction(Character character);

}
