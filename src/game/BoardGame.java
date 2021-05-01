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

    // Initialise the Count box to 1
    public void initializeFirstBox() {
        this.character.setCharacterPosition(1);
        System.out.println(character.getCharacterPosition());
    }

    // Getters & Setters
    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }

    public Character getCharacter() {
        return character;
    }
}
