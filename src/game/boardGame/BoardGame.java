package game.boardGame;

import character.Character;
import game.boardGame.cell.*;
import game.boardGame.cell.enemyCell.Dragon;
import game.boardGame.cell.enemyCell.Gobelin;
import game.boardGame.cell.enemyCell.Sorcerer;
import game.boardGame.cell.shieldCell.StandardPotion;
import game.boardGame.cell.surpriseCell.SurpriseCell;
import game.boardGame.cell.weapon.Club;
import game.boardGame.cell.weapon.Fireball;
import game.boardGame.cell.weapon.Thunderbolt;


import java.util.ArrayList;
import java.util.List;

public class BoardGame {

    // All attributes
    private int numberOfBoxes;
    private List<Cell> boardGame;
    private Character character;

    // Constructors
    public BoardGame(Character character) {
        this.numberOfBoxes = 64;
        this.character = character;
        this.boardGame = new ArrayList<Cell>();
    }

    // Methods
    // Initialise the Count box to 1
    public void initializeFirstBox() {
        character.setCharacterPosition(0);
        System.out.println("Vous commencez sur la case : " + character.getCharacterPosition());
    }
    // Current character position
    public void currentBox(int diceResult) {
        character.setCharacterPosition(diceResult);
        System.out.println("Vous venez de lancer le dé, le résultat est : " + diceResult);
        System.out.println("Votre personnage est maintenant sur la case : " + character.getCharacterPosition() + "/" + getNumberOfBoxes());
        cellContent(character.getCharacterPosition());
    }

    public void cellContent(int characterPosition) {
        switch (characterPosition) {
            case 1: {
                boardGame.add(new StandardPotion());
                boardGame.get(0).interaction(character);
                System.out.println(character.toString());
                break;
            }
            case 2: {
                boardGame.add(new Gobelin());
                boardGame.get(1).interaction(character);
                break;
            }
            case 3: {
                boardGame.add(new Fireball());
                boardGame.get(2).interaction(character);
                break;
            }
            case 4: {
                boardGame.add(new Sorcerer());
                boardGame.get(3).interaction(character);
                break;
            }
        }
    }

    // Getters & Setters
    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }
    public Character getCharacter() {
        return character;
    }
}
