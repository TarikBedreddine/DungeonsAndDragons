package game;

import character.Character;
import game.exceptions.CharacterOutsideBoardGame;
import menu.Navigation;

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
            character = navigation.startMenu(character);
        }
        this.boardGame = new BoardGame(this.character);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------- Le jeu va débuter, êtes-vous prêts ? -----------------");
        System.out.println("----------------------------------------------------------------------");

        // Initialize box to 1 of the boardGame
        boardGame.initializeFirstBox();

        // Store getters in variables
        int characterPosition = character.getCharacterPosition();
        int totalBoxes = boardGame.getNumberOfBoxes();
        // Try to catch an exception if character position > 64
        try {
            while (characterPosition < totalBoxes) {
                System.out.println("");
                System.out.println("Appuyer sur la touche \"Entrée\" pour lancer le dé");
                System.out.println("--------------------------------------------------");
                String isEnterPressed = scanner.nextLine();
                if (isEnterPressed.equals("")) {
                    // Throw the dice and set the new position
                    boardGame.currentBox(dice.throwDice());
                    characterPosition = character.getCharacterPosition();
                } else {
                    System.out.println("Attention : Seule la touche Entrée permet de lancer le dé ;)");
                }
                if (characterPosition > totalBoxes) {
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
}
