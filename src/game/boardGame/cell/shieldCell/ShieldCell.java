package game.boardGame.cell.shieldCell;
import character.Character;

import game.boardGame.cell.Cell;

public abstract class ShieldCell extends Cell {

    // Attributes
    private String name;
    private int life;

    // Constructors
    public ShieldCell(String shieldName, int lifeRescue) {
        this.name = shieldName;
        this.life = lifeRescue;
        System.out.println(toString());
    }

    // Methods
    @Override
    public void interaction(Character character) {

    }


    // Getters & Setters
    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShieldCell{" +
                "name='" + name + '\'' +
                ", life=" + life +
                '}';
    }
}


