package game.boardGame;

import game.boardGame.cell.*;


import java.util.*;

/**
 * BoardGame contain an ArrayList of all the cells
 * It initialize, generate random stuffs & enemies and populate the cells
 *
 * This Class is handled by Game
 * @see game.Game
 *
 * @author Tarik
 *
 */
public class BoardGame {

    // All attributes
    private int numberOfCells;
    private ArrayList<Cell> boardGame;

    /**
     * Constructor of BoardGame
     *
     * Initialize :
     *      numberOfCells = total number of cells
     *      boardGame = Arraylist which will store all Cells
     *
     */
    public BoardGame() {
        this.numberOfCells = 64;
        this.boardGame = new ArrayList<Cell>();
    }

    /**
     * Thanks to Reflection :
     *      I retrieve the instance of the typeOfCell which is a string (weapons, enemies, healthPotions...)
     *      I Cast this instance to store it in the ArrayList Cell
     *
     * @param numberOfCellsToCreate int
     *      Number of items / enemies to populate inside the ArrayList
     * @param boardGame ArrayList
     *      Object which will store all items / enemies
     * @param typeOfCell String
     *      Which type of cell will populate the ArrayList
     *
     */
    public void addItemInBoardGame(int numberOfCellsToCreate, ArrayList<Cell> boardGame, String typeOfCell) {

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

    /**
     * Enumerate the possible pops for the different cells
     *
     * {@link game.boardGame.cell.enemyCell}
     * {@link game.boardGame.cell.attackEquipment}
     * {@link game.boardGame.cell.chest}
     *
     */
    public enum possibleCell {
        Dragon, Sorcerer, Goblin, Club, Sword, Thunderbolt, Fireball, StandardPotion, BigPotion
    }

    /**
     * cellContent will initialize the first cell to null and call the method addItemInBoardGame to populate the ArrayList.
     * {@link #generateRandomCells(String)}
     * {@link #addItemInBoardGame(int, ArrayList, String)}
     *
     * @param level String
     *      level of the game (Easy, medium, hard)
     */
    public void cellContent(String level) {
        // Initialize the index 0 to null because character start game in cell 1
        boardGame.add(0, null);
        // addItemInBoardGame permit to set the value of the cell
        addItemInBoardGame(generateRandomCells(level).get("dragons"), this.boardGame, "enemyCell." + possibleCell.Dragon.name());
        addItemInBoardGame(generateRandomCells(level).get("sorcerers"), this.boardGame, "enemyCell." + possibleCell.Sorcerer.name());
        addItemInBoardGame(generateRandomCells(level).get("goblins"), this.boardGame, "enemyCell." + possibleCell.Goblin.name());
        addItemInBoardGame(generateRandomCells(level).get("clubs"), this.boardGame, "attackEquipment.weapon." + possibleCell.Club.name());
        addItemInBoardGame(generateRandomCells(level).get("swords"), this.boardGame, "attackEquipment.weapon." + possibleCell.Sword.name());
        addItemInBoardGame(generateRandomCells(level).get("thunderbolts"), this.boardGame, "attackEquipment.spell." + possibleCell.Thunderbolt.name());
        addItemInBoardGame(generateRandomCells(level).get("fireballs"), this.boardGame, "attackEquipment.spell." + possibleCell.Fireball.name());
        addItemInBoardGame(generateRandomCells(level).get("standardPotions"), this.boardGame, "chest.healthCell." + possibleCell.StandardPotion.name());
        addItemInBoardGame(generateRandomCells(level).get("bigPotions"), this.boardGame, "chest.healthCell." + possibleCell.BigPotion.name());
    }

    /**
     * Depending with the level given, this method will return an HashMap.
     * This HashMap can used with get() method to retrieve how many item to create
     *
     * @param level String
     * @return HashMap Of String and Integer
     *      String represent the name of the item / enemy
     *      Integer represent the number of item / enemy to create
     *
     */
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
