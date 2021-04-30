package game;

import character.Character;
import menu.Navigation;

public class Game {

    // All attributes
    private Object character;

    // Constructor of Game
    public Game(Object characterInstance) {
        this.character = characterInstance;
    }

    // This method will start the game
    public void startGame() {
        System.out.println("Le jeu va débuter, vous êtes prêts ?");
        System.out.println(character.toString());
    }


}
