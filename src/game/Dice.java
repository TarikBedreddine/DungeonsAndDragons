package game;

public class Dice {

    // Attributes
    private int diceValue;

    // Constructors
    public Dice() {
        this.diceValue = 0;
    }

    // Methods
    public int throwDice (){
        int range = (6 - 1) + 1;
        this.diceValue = (int)(Math.random() * range) + 1;
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
