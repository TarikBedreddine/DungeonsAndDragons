package game.boardGame.cell.enemyCell;
import character.Character;

import game.Game;
import game.boardGame.cell.Cell;

public abstract class EnemyCell extends Cell {

    // Attributes
    private String enemyName;
    private int enemyLife;
    private int enemyAttack;

    // Constructors
    public EnemyCell(String enemyName, int enemyLife, int enemyAttack) {
        this.enemyName = enemyName;
        this.enemyLife = enemyLife;
        this.enemyAttack = enemyAttack;
    }

    // Methods
    @Override
    public void interaction(Character character) {
        System.out.println("");
        System.out.println("Oh non ! un " + enemyName);
        while (this.getEnemyLife() > 0 && character.getLife() > 0) {
            System.out.println("");
            System.out.println("Votre personnage attaque ... ");
            if (character.getWeaponName() != null) {
                setEnemyLife(getEnemyLife() - character.getAttack() - character.getWeaponDamage());
            } else {
                setEnemyLife(getEnemyLife() - character.getAttack());
            }
            System.out.println("Vous avez infligé " + (character.getAttack() + character.getWeaponDamage()) + " de dégâts. L'ennemi a désormais : " + this.getEnemyLife() + " de vie");
            if (this.getEnemyLife() > 0) {
                character.setLife(character.getLife() - this.enemyAttack);
                System.out.println("...");
                System.out.println("L'ennemi vient de vous infliger " + this.enemyAttack + " points de vie. Votre vie passe donc maintenant à " + character.getLife());
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
