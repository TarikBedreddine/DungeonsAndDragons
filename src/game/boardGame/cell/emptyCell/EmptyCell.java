package game.boardGame.cell.emptyCell;

import game.boardGame.cell.Cell;

public class EmptyCell extends Cell {

    // Attributes

    // Constructors
    public EmptyCell() {
        cellFocused();
    }

    // Methods
    @Override
    public void cellFocused() {
        System.out.println("Ceci est une case vide");
    }

    // Getters & Setters
}
