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
        // Control if the character has his full life or not
        if (character.getLife() < character.getMinLife()) {
            character.setLife(character.getLife() + this.life);
            // if the potion give more life than the max life, it automatically set the max life
            if (character.getLife() > character.getMinLife()) {
                character.setLife(character.getMinLife());
            }
            System.out.println("");
            System.out.println("Bonne nouvelle !! vous êtes tombé sur une " + this.name + ", vos points de vies sont maintenant de : " + character.getLife());
        } else {
            System.out.println("");
            System.out.println("Vous avez déjà tous vos points de vie, vous n'avez pas besoin de cette " + this.name);
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


