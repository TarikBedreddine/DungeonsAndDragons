package game.boardGame.cell.enemyCell;
import character.Character;

import game.boardGame.cell.attackEquipment.AttackEquipment;
import game.Game;
import game.boardGame.cell.Cell;
import stuff.Stuff;

/**
 * The Class handle Dragon, Goblin and Sorcerer interaction with the character
 *
 * @author Tarik
 *
 * @see Cell
 * @see Dragon
 * @see Goblin
 * @see Sorcerer
 */
public abstract class EnemyCell implements Cell {

    // Attributes
    private String enemyName;
    private int enemyLife;
    private int enemyAttack;

    /**
     * Initialize enemyName, enemyLife, enemyAttack & attackEquipment
     *
     * @param enemyName String
     * @param enemyLife int
     * @param enemyAttack int
     *
     * {@link Dragon#Dragon()}
     * {@link Goblin#Goblin()}
     * {@link Sorcerer#Sorcerer()}
     *
     */
    public EnemyCell(String enemyName, int enemyLife, int enemyAttack) {
        this.enemyName = enemyName;
        this.enemyLife = enemyLife;
        this.enemyAttack = enemyAttack;
    }

    /**
     * Interaction between Enemy and Character
     * Features :
     *      - Attack enemy without weapon
     *      - Attack enemy with a weapon or spell
     *
     * @param character Character
     *
     * @param stuff
     * @see AttackEquipment
     */
    @Override
    public void interaction(Character character, Stuff stuff) {
        System.out.println("");
        System.out.println("Oh non ! un " + enemyName);
        while (this.getEnemyLife() > 0 && character.getLife() > 0) {
            System.out.println("");
            System.out.println("Votre personnage attaque ... ");

            // Reduce enemy life
            setEnemyLife(getEnemyLife() - character.getTotalAttack());

            System.out.println("Vous avez infligé " + (character.getTotalAttack()) + " de dégâts. L'ennemi a désormais : " + this.getEnemyLife() + " points de vie");
            if (this.getEnemyLife() > 0) {
                character.setLife(character.getLife() - this.enemyAttack);
                System.out.println("...");
                System.out.println("L'ennemi vient de vous infliger " + this.enemyAttack + " points de vie. Votre vie passe donc maintenant à " + character.getLife() + " de vie.");
            }
        }
        if (character.getLife() > 0 ) {
            System.out.println("");
            System.out.println("Bravo vous avez tuer l'ennemi");
        } else {
            System.out.println("");
            System.out.println("Vous êtes MORT !");
            System.out.println("");
            System.out.println("Retour au menu principal");
            Game newGame = new Game();
            newGame.runGame();
        }

    }

    // Getters & Setters
    public int getEnemyLife() {
        return enemyLife;
    }

    public void setEnemyLife(int enemyLife) {
        this.enemyLife = enemyLife;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public void setEnemyAttack(int enemyAttack) {
        this.enemyAttack = enemyAttack;
    }

    @Override
    public String toString() {
        return "EnemyCell{" +
                "enemyLife=" + enemyLife +
                ", enemyAttack=" + enemyAttack +
                '}';
    }
}
