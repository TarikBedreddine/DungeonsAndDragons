package menu;

import game.Game;

public class App {

    // Constructor of the App Class
    public void App () {

    }

    // Main entry point of the project
    public static void main (String[] args ) {
        // instance of the Game class to start the menu
        Game newGame = new Game();
        newGame.runGame();
    }
}

