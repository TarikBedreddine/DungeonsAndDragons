package game.boardGame.cell.surpriseCell;

import game.boardGame.cell.Cell;

public class SurpriseCell extends Cell {

    // Attributes

    // Constructors
    public SurpriseCell() {
        cellFocused();
    }

    // Methods
    @Override
    public void cellFocused() {
        System.out.println("C'est une random case");
    }

    // Getters & Setters
}
