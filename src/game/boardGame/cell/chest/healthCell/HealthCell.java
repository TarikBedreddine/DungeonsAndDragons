package game.boardGame.cell.chest.healthCell;
import character.Character;

import game.boardGame.cell.Cell;
import stuff.Stuff;

/**
 * The Class is dedicated for all Characters.
 * It handle bigPotion & standardPotion interaction with the character
 *
 *
 * @see Cell
 * @see BigPotion
 * @see StandardPotion
 */
public abstract class HealthCell implements Cell {

    // Attributes
    private String name;
    private int life;

    /**
     * Constructor
     * Retrieve data given by child constructor and initialize attributes
     *
     * @param shieldName String
     *      Name of the shield
     * @param lifeRescue int
     *      life regenerated
     *
     * {@link BigPotion#BigPotion()}
     * {@link StandardPotion#StandardPotion()}
     *
     */
    public HealthCell(String shieldName, int lifeRescue) {
        this.name = shieldName;
        this.life = lifeRescue;
    }

    /**
     * This method set all actions between the item and the character
     * It regenerate the life to character
     *
     *
     * @param character Character
     *      Character to deal with the interaction
     *
     */
    @Override
    public void interaction(Character character, Stuff stuff) {
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
            System.out.println("Vous avez déjà tous vos points de vie");
            stuff.addItemToBackpack(this, this.name);
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
        return  name + " restaure " +
                life + " points de vie. ";
    }
}


