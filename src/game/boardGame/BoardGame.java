package game.boardGame;

import game.boardGame.cell.*;


import java.util.*;

public class BoardGame {

    // All attributes
    private int numberOfCells;
    private ArrayList<Cell> boardGame;
    private ArrayList<Integer> listNumbers;
    private String level;

    // Constructors
    public BoardGame() {
        this.numberOfCells = 64;
        this.boardGame = new ArrayList<Cell>();
    }

    // Methods
    // Update the values of boardgame List with objects
    public void addItemInBoardGame(int numberOfCellsToCreate, List<Cell> boardGame, String typeOfCell) {

        Random rand = new Random();
        for (int i = 1; i <= numberOfCellsToCreate; i++) {
            int index = rand.nextInt(listNumbers.size());
            while (listNumbers.get(index) == null) {
                index = rand.nextInt(listNumbers.size());
            }
            ////////////////////////////////////////////////
            try {
                Class<?> item = Class.forName("game.boardGame.cell." + typeOfCell);
                Object itemInstance = item.newInstance();
                Cell castItemInstance = ((Cell) itemInstance);
                boardGame.set(index, castItemInstance);

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            /////////////////////////////////////////////////

            listNumbers.set(index, null);
        }
    }

    // initialize all the cells of the list to null
    public void initializeCellsBoardGame() {
        for (int i = 0; i <= 64; i++) {
            if (i == 0 || i == 64) {
                boardGame.add(i, null);
                continue;
            }
            boardGame.add(i, null);
            listNumbers.add(i);
        }
    }

    // Enumerate possible pop in the different cells
    public enum possibleCell {
        Dragon, Sorcerer, Goblin, Club, Sword, Thunderbolt, Fireball, StandardPotion, BigPotion
    }

    // indicate for each type of cell where they will pop
    public void cellContent(String level) {

        // addItemInBoardGame permit to set the value of the cell
        addItemInBoardGame(generateRandomCells("Easy").get("dragons"), this.boardGame, "enemyCell." + possibleCell.Dragon.name());
        addItemInBoardGame(generateRandomCells("Easy").get("sorcerers"), this.boardGame, "enemyCell." + possibleCell.Sorcerer.name());
        addItemInBoardGame(generateRandomCells("Easy").get("goblins"), this.boardGame, "enemyCell." + possibleCell.Goblin.name());
        addItemInBoardGame(generateRandomCells("Easy").get("clubs"), this.boardGame, "weapon." + possibleCell.Club.name());
        addItemInBoardGame(generateRandomCells("Easy").get("swords"), this.boardGame, "weapon." + possibleCell.Sword.name());
        addItemInBoardGame(generateRandomCells("Easy").get("thunderbolts"), this.boardGame, "weapon." + possibleCell.Thunderbolt.name());
        addItemInBoardGame(generateRandomCells("Easy").get("fireballs"), this.boardGame, "weapon." + possibleCell.Fireball.name());
        addItemInBoardGame(generateRandomCells("Easy").get("standardPotions"), this.boardGame, "healthCell." + possibleCell.StandardPotion.name());
        addItemInBoardGame(generateRandomCells("Easy").get("bigPotions"), this.boardGame, "healthCell." + possibleCell.BigPotion.name());
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
                cells.put("clubs", 9);
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
