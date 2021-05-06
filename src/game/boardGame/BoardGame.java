package game.boardGame;

import character.Character;
import game.boardGame.cell.*;
import game.boardGame.cell.enemyCell.Dragon;
import game.boardGame.cell.enemyCell.Goblin;
import game.boardGame.cell.enemyCell.Sorcerer;
import game.boardGame.cell.shieldCell.BigPotion;
import game.boardGame.cell.shieldCell.StandardPotion;
import game.boardGame.cell.weapon.Club;
import game.boardGame.cell.weapon.Fireball;
import game.boardGame.cell.weapon.Sword;
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

    // Update the values of boardgame List with objects
    public void addItemInBoardGame(int [] array, List<Cell> boardGame, possibleCell typeOfCell) {
        for (int value: array) {
            switch (typeOfCell) {
                case Dragon: {
                    boardGame.set(value, new Dragon());
                    break;
                }
                case Sorcerer: {
                    boardGame.set(value, new Sorcerer());
                    break;
                }
                case Goblin: {
                    boardGame.set(value, new Goblin());
                    break;
                }
                case Club: {
                    boardGame.set(value, new Club());
                    break;
                }
                case Sword: {
                    boardGame.set(value, new Sword());
                    break;
                }
                case Thunderbolt: {
                    boardGame.set(value, new Thunderbolt());
                    break;
                }
                case Fireball: {
                    boardGame.set(value, new Fireball());
                    break;
                }
                case StandardPotion: {
                    boardGame.set(value, new StandardPotion());
                    break;
                }
                case BigPotion: {
                    boardGame.set(value, new BigPotion());
                    break;
                }
            }
        }
    }

    // initialize all the cells of the list to null
    public void initializeCellsBoardGame() {
        for (int i = 0; i <= 64; i++) {
            boardGame.add(i, null);

        }
    }

    // Enumerate possible pop in the different cells
    public enum possibleCell {
        Dragon, Sorcerer, Goblin, Club, Sword, Thunderbolt, Fireball, StandardPotion, BigPotion
    }
    // indicate for each type of cell where they will pop
    public void cellContent() {
        // I store all enemies position in a standard array
        int[] dragons = {45, 52, 56, 62};
        int[] sorcerer = {10, 20, 25, 32, 35, 36, 37, 40, 44, 47};
        int[] goblins = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
        int[] clubs = {2, 11, 5, 22, 38};
        int[] swords = {19, 26, 42, 53};
        int[] thunderbolt = {1, 4, 8, 17, 23};
        int[] fireballs = {48, 49};
        int[] standardPotion = {7, 13, 31, 33, 39, 43};
        int[] bigPotion = {28, 41};

        // addItemInBoardGame permit to set the value of the cell
        addItemInBoardGame(dragons, this.boardGame, possibleCell.Dragon);
        addItemInBoardGame(sorcerer, this.boardGame, possibleCell.Sorcerer);
        addItemInBoardGame(goblins, this.boardGame, possibleCell.Goblin);
        addItemInBoardGame(clubs, this.boardGame, possibleCell.Club);
        addItemInBoardGame(swords, this.boardGame, possibleCell.Sword);
        addItemInBoardGame(thunderbolt, this.boardGame, possibleCell.Thunderbolt);
        addItemInBoardGame(fireballs, this.boardGame, possibleCell.Fireball);
        addItemInBoardGame(standardPotion, this.boardGame, possibleCell.StandardPotion);
        addItemInBoardGame(bigPotion, this.boardGame, possibleCell.BigPotion);
    }



    // Initialise the Count box to 1
    public void initializeFirstCellAndBoardGame() {
        character.setCharacterPosition(1);
        System.out.println("Vous commencez sur la case : " + character.getCharacterPosition());
        // Set all indexes of the boardgame to null
        initializeCellsBoardGame();
        cellContent();
    }

    // Current character position
    public void currentCell(int diceResult) {
        // if the last throw outbound the boardGame, then i fix the characterPosition to 64
        if ((character.getCharacterPosition() + diceResult) > numberOfBoxes) {
            // This line determine the exact number to add in the Character Setter to get 64
            character.setCharacterPosition(numberOfBoxes - character.getCharacterPosition());
        } else {
            character.setCharacterPosition(diceResult);
        }
        System.out.println("Vous venez de lancer le dé, le résultat est : " + diceResult);
        System.out.println("Votre personnage est maintenant sur la case : " + character.getCharacterPosition() + "/" + getNumberOfBoxes());
        // Check if there is an object in the List
        if (boardGame.get(character.getCharacterPosition()) != null)
            boardGame.get(character.getCharacterPosition()).interaction(character);
            System.out.println("");
            System.out.println(character.toString());
    }

    // Getters & Setters
    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }
    public Character getCharacter() {
        return character;
    }
}
