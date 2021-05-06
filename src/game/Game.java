package game;

import character.Character;
import game.boardGame.BoardGame;
import game.boardGame.cell.Cell;
import game.exceptions.CharacterOutsideBoardGame;
import menu.Navigation;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

    // All attributes
    private Character character;
    private Dice dice;
    private BoardGame boardGame;
    private Navigation navigation;
    private Scanner scanner;

    // Constructor of Game Class. Instance all Classes needed
    public Game() {
        this.character = null;
        this.navigation = new Navigation();
        this.dice = new Dice();
        this.scanner = new Scanner(System.in);
    }

    // This method will start the game
    public void runGame() {
        while (character == null) {
            this.character = navigation.startMenu(character);
        }
        boardGame = new BoardGame();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------- Le jeu va débuter, êtes-vous prêts ? -----------------");
        System.out.println("----------------------------------------------------------------------");

        // Initialize box to 1 of the boardGame
        initializeFirstCellAndBoardGame();

        // Store getters in variables
        int characterPosition = character.getCharacterPosition();
        int totalCells = boardGame.getNumberOfCells();
        // Try to catch an exception if character position > 64
        try {
            while (characterPosition < totalCells) {
                System.out.println("");
                System.out.println("Appuyer sur la touche \"Entrée\" pour lancer le dé");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                String isEnterPressed = scanner.nextLine();
                if (isEnterPressed.equals("")) {
                    // Throw the dice and set the new position
                    currentCell(dice.throwDice());
                    // set the characterPosition to the new position
                    characterPosition = character.getCharacterPosition();
                } else {
                    System.out.println("Attention : Seule la touche Entrée permet de lancer le dé ;)");
                }
                // Throw exception if character position outbound boardgame
                if (characterPosition > totalCells) {
                    character.setCharacterPosition(64);
                    throw new CharacterOutsideBoardGame();
                }
            }
        } catch (CharacterOutsideBoardGame err) {
            System.err.println("Vous avez dépassé la case 64, vous avez donc perdu ... C'est une blague bien sûr :) " + err);
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------- Félicitations vous avez fini le Jeu ------------------");
        System.out.println("----------------------------------------------------------------------");
        // Call the navigation method to leave or restart game
        navigation.leaveOrRestartGame(character);
    }

    // Initialise the Count box to 1
    public void initializeFirstCellAndBoardGame() {
        List<Cell> cellList = boardGame.getBoardGame();
        character.setCharacterPosition(1);
        System.out.println("Vous commencez sur la case : " + character.getCharacterPosition());
        // Set all indexes of the boardgame to null
        boardGame.initializeCellsBoardGame();
        boardGame.cellContent();
        Collections.shuffle(cellList);
    }

    // Current character position
    public void currentCell(int diceResult) {
        // if the last throw outbound the boardGame, then i fix the characterPosition to 64
        if ((character.getCharacterPosition() + diceResult) > boardGame.getNumberOfCells()) {
            // This line determine the exact number to add in the Character Setter to get 64
            character.setCharacterPosition(boardGame.getNumberOfCells() - character.getCharacterPosition());
        } else {
            character.setCharacterPosition(diceResult);
        }
        System.out.println("Vous venez de lancer le dé, le résultat est : " + diceResult);
        System.out.println("Votre personnage est maintenant sur la case : " + character.getCharacterPosition() + "/" + boardGame.getNumberOfCells());
        List<Cell> cellList = boardGame.getBoardGame();
        // Check if there is an object in the List
        if (cellList.get(character.getCharacterPosition()) != null)
            cellList.get(character.getCharacterPosition()).interaction(character);
        System.out.println("");
        System.out.println(character.toString());
    }
}
