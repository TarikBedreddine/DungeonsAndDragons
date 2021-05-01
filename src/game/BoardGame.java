package game;

import character.Character;

public class BoardGame {

    // All attributes
    private int numberOfBoxes;
    private Character character;

    // Constructors
    public BoardGame(Character character) {
        this.numberOfBoxes = 64;
        this.character = character;
    }

    // Methods
    // Initialise the Count box to 1
    public void initializeFirstBox() {
        this.character.setCharacterPosition(1);
    }

    public void currentBox() {
        this.character.getCharacterPosition();
        System.out.println("Votre personnage est sur la case : " + character.getCharacterPosition());
    }

    // Getters & Setters
    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }

    public Character getCharacter() {
        return character;
    }
}
