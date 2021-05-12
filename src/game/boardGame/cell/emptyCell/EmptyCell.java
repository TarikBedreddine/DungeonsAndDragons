package game.boardGame.cell.emptyCell;

import character.Character;
import game.boardGame.cell.Cell;

/**
 * It handle interaction when the character found an empty cell
 *
 * @see Cell
 */
public class EmptyCell extends Cell {

    // Attributes
    private boolean emptyCell;

    /**
     * Constructor
     * Initialize the attribute emptyCell to true
     *
     */
    public EmptyCell() {
        this.emptyCell = true;
    }

    /**
     * This method will only display messages to the user, to indicate an empty cell
     *
     * @param character Character
     *      Character to deal with the interaction
     *
     */
    @Override
    public void interaction(Character character) {
        System.out.println("");
        System.out.println("Cette case vide n'a aucun effet sur vous :)");
        System.out.println("Vous concervez vos propriétés : ");
        System.out.println("");
    }

    // Getters & Setters
    public boolean isEmptyCell() {
        return emptyCell;
    }
}
