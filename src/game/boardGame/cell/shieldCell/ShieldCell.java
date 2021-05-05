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
        if (character.getLife() < character.getMaxLife()) {
            character.setLife(character.getLife() + this.life);
            System.out.println("");
            System.out.println("Bonne nouvelle !! vous êtes tombés sur une potion, vos point de vies sont maintenant de : " + character.getLife());

        }
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


