package game.boardGame;

import character.Character;
import game.boardGame.cell.*;
import game.boardGame.cell.enemyCell.Dragon;
import game.boardGame.cell.enemyCell.Gobelin;
import game.boardGame.cell.enemyCell.Sorcerer;
import game.boardGame.cell.shieldCell.BigPotion;
import game.boardGame.cell.shieldCell.StandardPotion;
import game.boardGame.cell.surpriseCell.SurpriseCell;
import game.boardGame.cell.weapon.Club;
import game.boardGame.cell.weapon.Fireball;
import game.boardGame.cell.weapon.Sword;
import game.boardGame.cell.weapon.Thunderbolt;


import java.lang.reflect.Array;
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
    public void initializeFirstCell() {
        character.setCharacterPosition(1);
        System.out.println("Vous commencez sur la case : " + character.getCharacterPosition());
        // Set all indexes of the boardgame to null
        initializeBoardGame();
        cellContent();
    }
    // Current character position
    public void currentCell(int diceResult) {
        character.setCharacterPosition(diceResult);
        System.out.println("Vous venez de lancer le dé, le résultat est : " + diceResult);
        System.out.println("Votre personnage est maintenant sur la case : " + character.getCharacterPosition() + "/" + getNumberOfBoxes());
        if (boardGame.get(character.getCharacterPosition()) != null)
        boardGame.get(character.getCharacterPosition()).interaction(character);
        System.out.println(character.toString());
        }


    // initialize all the cells of the list to null
    public void initializeBoardGame() {
        for (int i = 0; i <= 64; i++) {
            boardGame.add(i, null);
        }
    }

    // Update the values of boardgame List with objects
    public void addItemInBoardGame(int [] array, List boardGame, Object item) {
        for (int value: array) {
            boardGame.set(value, item);
        }
    }

    public void cellContent() {
        // I store all enemies position in a standard array
        int[] dragons = {45, 52, 56, 62};
        int[] sorcerer = {10, 20, 25, 32, 35, 36, 37, 40, 44, 47};
        int[] gobelins = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
        int[] clubs = {2, 11, 5, 22, 38};
        int[] swords = {19, 26, 42, 53};
        int[] thunderbolt = {1, 4, 8, 17, 23};
        int[] fireballs = {48, 49};
        int[] standardPotion = {7, 13, 31, 33, 39, 43};
        int[] bigPotion = {28, 41};
        // addItemInBoardGame permit to set the value of the cell with the correct object
        addItemInBoardGame(dragons, this.boardGame, new Dragon());
        addItemInBoardGame(sorcerer, this.boardGame, new Sorcerer());
        addItemInBoardGame(gobelins, this.boardGame, new Gobelin());
        addItemInBoardGame(clubs, this.boardGame, new Club());
        addItemInBoardGame(swords, this.boardGame, new Sword());
        addItemInBoardGame(thunderbolt, this.boardGame, new Thunderbolt());
        addItemInBoardGame(fireballs, this.boardGame, new Fireball());
        addItemInBoardGame(standardPotion, this.boardGame, new StandardPotion());
        addItemInBoardGame(bigPotion, this.boardGame, new BigPotion());
    }

    // Getters & Setters
    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }
    public Character getCharacter() {
        return character;
    }
}
