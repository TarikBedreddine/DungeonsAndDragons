package game.boardGame.cell.enemyCell;

import game.boardGame.cell.Cell;

public abstract class EnemyCell extends Cell {

    // Attributes
    private int life;
    private int attack;

    // Constructors
    public EnemyCell(int enemyLife, int enemyAttack) {
        cellFocused();
        this.life = enemyLife;
        this.attack = enemyAttack;
        System.out.println(toString());
    }

    // Methods
    @Override
    public void cellFocused() {
    }

    // Getters & Setters


    public String toString() {
        return "EnemyCell{" +
                "life=" + this.life +
                ", attack=" + this.attack +
                '}';
    }
}
