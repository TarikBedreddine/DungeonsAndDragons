package game;

/**
 * Dice permit to return a random value to allow character to move
 *
 * @author Tarik
 *
 * @see Game
 *
 */
public class Dice {

    // Attributes
    private int diceValue;

    // Constructors
    public Dice() {
        this.diceValue = 0;
    }

    /**
     * implement a method throwDice to get a random number between 1-6
     * Used in :
     * {@link game.Game#currentCell(int)}
     *
     *
     * @return int
     *      Return a number between 1-6
     *
     */
    public int throwDice (){
        int range = (6 - 1) + 1;
        this.diceValue = (int)(Math.random() * range) + 1;
        //diceValue = 1;
        return diceValue;
    }


    //Getters & Setters
    public int getDiceValue() {
        return diceValue;
    }
    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }
}
