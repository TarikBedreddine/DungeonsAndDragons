package game.boardGame.cell.surpriseCell;

import game.boardGame.cell.Cell;
import game.boardGame.cell.shieldCell.BigPotion;
import game.boardGame.cell.shieldCell.StandardPotion;
import character.Character;

public class SurpriseCell extends Cell {

    // Attributes


    // Constructors
    public SurpriseCell() {

    }

    public void randomSurprise() {
        int range = (2 - 1) + 1;
        int randomResult = (int)(Math.random() * range) + 1;
        if (randomResult == 1) {
            StandardPotion sp = new StandardPotion();
        } else {
            BigPotion bp = new BigPotion();
        }
    }

    // Methods
    @Override
    public void interaction(Character character) {
        System.out.println("C'est une random case");
        randomSurprise();
    }

    // Getters & Setters
}
