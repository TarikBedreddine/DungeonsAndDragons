package game;

import character.Character;

public class BoardGame {

    // All attributes
    private int numberOfBoxes;
    private int[] boardGame;
    private Character character;

    // Constructors
    public BoardGame(Character character) {
        this.numberOfBoxes = 64;
        this.character = character;
        this.boardGame = new int [numberOfBoxes];
    }

    // Methods
    // Initialise the Count box to 1
    public void initializeFirstBox() {
        character.setCharacterPosition(1);
        System.out.println("Vous commencez sur la case : " + character.getCharacterPosition());
    }
    // Current character position
    public void currentBox(int diceResult) {
        character.setCharacterPosition(diceResult);
        System.out.println("Vous venez de lancer le dé, le résultat est : " + diceResult);
        System.out.println("Votre personnage est maintenant sur la case : " + character.getCharacterPosition() + "/" + getNumberOfBoxes());
    }

    // Getters & Setters
    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }
    public Character getCharacter() {
        return character;
    }
}
