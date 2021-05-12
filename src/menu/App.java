package menu;

import game.Game;

/**
 * Define the main of the program
 *
 * @author Tarik
 *
 * @see Game
 *
 */
public class App {

    /**
     * Constructor
     * @deprecated
     *
     */
    public void App () {

    }

    /**
     * Main entry point of the Game
     *
     * @param args Array of strings
     *      Arguments given the main before the execution
     *
     * {@link Game#runGame()}
     */
    public static void main (String[] args ) {
        // instance of the Game class to start the menu
        Game newGame = new Game();
        newGame.runGame();
    }
}

