package game;

import character.Character;
import menu.Navigation;

public class Game {

    // All attributes
    private Character character;
    private Dice dice;
    private BoardGame boardGame;
    private Navigation navigation;

    // Constructor of Game Class. Instance all Classes needed
    public Game() {
        this.character = null;
        this.navigation = new Navigation();
        this.dice = new Dice();
    }

    // This method will start the game
    public void runGame() {
        character = navigation.startMenu(character);
        this.boardGame = new BoardGame(this.character);
        System.out.println("Le jeu va débuter, êtes-vous prêts ?");
        // Initialize box to 1 of the boardGame
        boardGame.initializeFirstBox();
    }
}
