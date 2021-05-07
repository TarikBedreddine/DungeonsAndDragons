package game.boardGame.cell.healthCell;
import character.Character;

import game.boardGame.cell.Cell;

public abstract class healthCell extends Cell {

    // Attributes
    private String name;
    private int life;

    // Constructors
    public healthCell(String shieldName, int lifeRescue) {
        this.name = shieldName;
        this.life = lifeRescue;
    }

    // Methods
    @Override
    public void interaction(Character character) {
        if (character.getLife() < character.getMaxLife()) {
            character.setLife(character.getLife() + this.life);
            if (character.getLife() > character.getMaxLife()) {
                character.setLife(character.getMaxLife());
            }
            System.out.println("");
            System.out.println("Bonne nouvelle !! vous êtes tombé sur une " + this.name + ", vos points de vies sont maintenant de : " + character.getLife());
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


