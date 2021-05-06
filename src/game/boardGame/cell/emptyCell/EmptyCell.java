package game.boardGame.cell.emptyCell;

import character.Warrior;
import character.Character;
import game.boardGame.cell.Cell;

public class EmptyCell extends Cell {

    // Attributes
    private boolean emptyCell;

    // Constructors
    public EmptyCell() {
        this.emptyCell = true;
    }

    // Methods
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
