package game.boardGame.cell.enemyCell;
import character.Character;

import equipment.attackEquipment;
import game.Game;
import game.boardGame.cell.Cell;

public abstract class EnemyCell extends Cell {

    // Attributes
    private String enemyName;
    private int enemyLife;
    private int enemyAttack;
    private attackEquipment attackEquipment;

    // Constructors
    public EnemyCell(String enemyName, int enemyLife, int enemyAttack) {
        this.enemyName = enemyName;
        this.enemyLife = enemyLife;
        this.enemyAttack = enemyAttack;
        this.attackEquipment = new attackEquipment();
    }

    // Methods
    @Override
    public void interaction(Character character) {
        System.out.println("");
        System.out.println("Oh non ! un " + enemyName);
        while (this.getEnemyLife() > 0 && character.getLife() > 0) {
            System.out.println("");
            System.out.println("Votre personnage attaque ... ");

            // Reduce enemy life
            setEnemyLife(getEnemyLife() - character.getAttack() - attackEquipment.getEquipmentDamage());

            System.out.println("Vous avez infligé " + (character.getAttack() + attackEquipment.getEquipmentDamage()) + " de dégâts. L'ennemi a désormais : " + this.getEnemyLife() + " points de vie");
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
