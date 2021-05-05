package game.boardGame.cell.enemyCell;
import character.Character;

import game.boardGame.cell.Cell;

public abstract class EnemyCell extends Cell {

    // Attributes
    private int life;
    private int attack;

    // Constructors
    public EnemyCell(int enemyLife, int enemyAttack) {
        this.life = enemyLife;
        this.attack = enemyAttack;
        System.out.println(toString());
    }

    // Methods
    @Override
    public void interaction(Character character) {
        while (this.getLife() > 0 && character.getLife() > 0) {
            System.out.println("");
            System.out.println("Votre personnage attaque ... ");
            setLife(getLife() - character.getAttack());
            System.out.println("");
            System.out.println("Vous avez infligé " + character.getAttack() + " de dégâts. L'ennemi a désormais : " + this.getLife() + " de vie");
            if (this.getLife() > 0) {
                character.setLife(character.getLife() - this.attack);
                System.out.println("L'ennemi vient de vous infliger " + this.attack + ". Votre vie passe donc maintenant à " + character.getLife());
            }
        }
        if (character.getLife() > 0 ) {
            System.out.println("");
            System.out.println("Bravo vous avez tuer l'ennemi");
        } else {
            System.out.println("");
            System.out.println("Vous êtes MORT !");
        }

    }

    // Getters & Setters
    public int getAttack() {
        return attack;
    }

    public int getLife() {
        return life;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String toString() {
        return "EnemyCell{" +
                "life=" + this.life +
                ", attack=" + this.attack +
                '}';
    }
}
