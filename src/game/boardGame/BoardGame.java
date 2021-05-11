package game.boardGame;

import game.boardGame.cell.*;


import java.util.*;

public class BoardGame {

    // All attributes
    private int numberOfCells;
    private ArrayList<Cell> boardGame;

    // Constructors
    public BoardGame() {
        this.numberOfCells = 64;
        this.boardGame = new ArrayList<Cell>();
    }

    // Methods
    // Update the values of boardgame List with objects
    public void addItemInBoardGame(int numberOfCellsToCreate, List<Cell> boardGame, String typeOfCell) {

            for (int j = 1; j <= numberOfCellsToCreate; j++) {
                // Reflection to get the instance of each item thanks to the name of the Class
                try {
                    Class<?> item = Class.forName("game.boardGame.cell." + typeOfCell);
                    Object itemInstance = item.newInstance();
                    Cell castItemInstance = ((Cell) itemInstance);
                    boardGame.add(j, castItemInstance);

                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    // Enumerate the possible pops in the different cells
    public enum possibleCell {
        Dragon, Sorcerer, Goblin, Club, Sword, Thunderbolt, Fireball, StandardPotion, BigPotion
    }

    // indicate for each type of cell where they will pop
    public void cellContent(String level) {
        // Initialize the index 0 to null because character start game in cell 1
        boardGame.add(0, null);
        // addItemInBoardGame permit to set the value of the cell
        addItemInBoardGame(generateRandomCells(level).get("dragons"), this.boardGame, "enemyCell." + possibleCell.Dragon.name());
        addItemInBoardGame(generateRandomCells(level).get("sorcerers"), this.boardGame, "enemyCell." + possibleCell.Sorcerer.name());
        addItemInBoardGame(generateRandomCells(level).get("goblins"), this.boardGame, "enemyCell." + possibleCell.Goblin.name());
        addItemInBoardGame(generateRandomCells(level).get("clubs"), this.boardGame, "weapon." + possibleCell.Club.name());
        addItemInBoardGame(generateRandomCells(level).get("swords"), this.boardGame, "weapon." + possibleCell.Sword.name());
        addItemInBoardGame(generateRandomCells(level).get("thunderbolts"), this.boardGame, "weapon." + possibleCell.Thunderbolt.name());
        addItemInBoardGame(generateRandomCells(level).get("fireballs"), this.boardGame, "weapon." + possibleCell.Fireball.name());
        addItemInBoardGame(generateRandomCells(level).get("standardPotions"), this.boardGame, "healthCell." + possibleCell.StandardPotion.name());
        addItemInBoardGame(generateRandomCells(level).get("bigPotions"), this.boardGame, "healthCell." + possibleCell.BigPotion.name());
    }

    public Map<String, Integer> generateRandomCells(String level) {
        HashMap<String, Integer> cells = new HashMap<String, Integer>();
        switch (level) {
            case "Easy": {
                cells.put("dragons", 2);
                cells.put("sorcerers", 4);
                cells.put("goblins", 9);
                cells.put("clubs", 6);
                cells.put("swords", 10);
                cells.put("thunderbolts", 6);
                cells.put("fireballs", 10);
                cells.put("standardPotions", 9);
                cells.put("bigPotions", 6);
                break;
            }
            case "Medium": {
                cells.put("dragons", 4);
                cells.put("sorcerers", 7);
                cells.put("goblins", 12);
                cells.put("clubs", 9);
                cells.put("swords", 5);
                cells.put("thunderbolts", 9);
                cells.put("fireballs", 5);
                cells.put("standardPotions", 10);
                cells.put("bigPotions", 3);
                break;
            }
            case "Hard": {
                cells.put("dragons", 8);
                cells.put("sorcerers", 10);
                cells.put("goblins", 8);
                cells.put("clubs", 7);
                cells.put("swords", 6);
                cells.put("thunderbolts", 9);
                cells.put("fireballs", 5);
                cells.put("standardPotions", 6);
                cells.put("bigPotions", 3);
                break;
            }
        }
        return cells;
    }

    // Getters & Setters
    public int getNumberOfCells() {
        return numberOfCells;
    }

    public List<Cell> getBoardGame() {
        return boardGame;
    }
}
