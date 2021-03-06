package game;

import character.Character;
import database.DataBase;
import game.boardGame.BoardGame;
import game.boardGame.cell.Cell;
import game.exceptions.CharacterOutsideBoardGame;
import menu.Navigation;
import stuff.Stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Major Class - interact with the different parts of the programm
 * @author Tarik
 *
 * @see Character
 * @see Dice
 * @see BoardGame
 * @see Navigation
 * @see Scanner
 *
 */
public class Game {

    // All attributes
    private Character character;
    private Dice dice;
    private BoardGame boardGame;
    private Navigation navigation;
    private Scanner scanner;
    private String difficultLevel;
    private DataBase dataBase;
    private boolean restoredCharacter;
    private ArrayList<Object> gameData;
    private Stuff stuff;

    /**
     * Constructor
     * Initialize character, navigation, dice & scanner
     *
     */
    public Game() {
        this.character = null;
        this.navigation = new Navigation();
        this.dice = new Dice();
        this.scanner = new Scanner(System.in);
        this.difficultLevel = "";
        this.dataBase = new DataBase();
        this.restoredCharacter = false;
        this.stuff = new Stuff("");
    }

    /**
     * runGame permit :
     *      To call the Navigation to Create a character
     * {@link menu.Navigation#startMenu(DataBase)} (Character)}
     *
     *      To interact with the boardGame (initialize total number of Cells and an ArrayList for the cells)
     * @see BoardGame
     *
     *      Set the characterPosition and Level
     * {@link #initializeFirstCellAndBoardGame()}
     *
     *      Get value of dice, set newCharacterPosition, start interaction
     * {@link #currentCell(int)}
     *
     *      If characterPosition outbound the boardGame, an exception is throwed
     * @see game.exceptions.CharacterOutsideBoardGame
     *
     *      At thed end of the game user can restart or leave the game
     *{@link menu.Navigation#leaveOrRestartGame(Character)}
     *
     *
     */
    public void runGame() {

        gameData = navigation.startMenu(dataBase);
        character = ((Character) gameData.get(0));
        if (character.getCharacterPosition() > 1) {
            this.restoredCharacter = true;
            this.difficultLevel = ((String) gameData.get(1));
        }

        if (this.difficultLevel.equals("")) {
            this.difficultLevel = navigation.difficultLevel();
        }

        boardGame = new BoardGame();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------- Le jeu va d??buter, ??tes-vous pr??ts ? -----------------");
        System.out.println("----------------------------------------------------------------------");

        // Initialize box to 1 of the boardGame
        initializeFirstCellAndBoardGame();

        // Store getters in variables
        int characterPosition = character.getCharacterPosition();
        int totalCells = boardGame.getNumberOfCells();
        // Try to catch an exception if character position > 64
        try {
            while (characterPosition < totalCells) {
                ArrayList<String> questions = new ArrayList<>();
                questions.add(" 1 - Lancer le d??");
                questions.add(" 2 - Sauvegarder la partie");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");

                int choice = navigation.askQuestion(questions);

                if (choice == 1) {
                    // Throw the dice and set the new position
                    currentCell(dice.throwDice());
                    // set the characterPosition to the new position
                    characterPosition = character.getCharacterPosition();
                } else if (choice == 2) {
                    askForSaveCharacter();
                }
                // Throw exception if character position outbound boardgame
                if (characterPosition > totalCells) {
                    character.setCharacterPosition(64);
                    throw new CharacterOutsideBoardGame();
                }
            }
        } catch (CharacterOutsideBoardGame err) {
            System.err.println("Vous avez d??pass?? la case 64, vous avez donc perdu ... C'est une blague bien s??r :) " + err);
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------- F??licitations vous avez fini le Jeu ------------------");
        System.out.println("----------------------------------------------------------------------");

        askForSaveCharacter();

        // Call the navigation method to leave or restart game
        navigation.leaveOrRestartGame(character);
    }

    /**
     * This method :
     *      Set the character position the first cell
     * {@link character.Character#setCharacterPosition(int)}
     *
     *
     *      Retrieve the object BoardGame
     * {@link BoardGame#getBoardGame()}
     *
     *
     *      Call the cellContent method with the level desired (Easy, Medium, Hard) to populate the Cell ArrayList with Enemies and Stuffs
     * {@link BoardGame#cellContent(String)}
     *
     *      Finally, the boardGame is shuffled to get random loots on the map
     */
    public void initializeFirstCellAndBoardGame() {
        List<Cell> cellList = boardGame.getBoardGame();
        character.setCharacterPosition(1);
        System.out.println("Vous commencez sur la case : " + character.getCharacterPosition());
        // Set all indexes of the boardgame to null
        //boardGame.initializeCellsBoardGame();
        boardGame.cellContent(this.difficultLevel);
        // subList permit in the case to begin the shuffle at index 1
        Collections.shuffle(cellList.subList(1, (cellList.size() - 1)));
    }

    /**
     * @param diceResult int
     *      diceResult is a random number between 1 - 6
     *
     * currentCell :
     *      Add result of the dice to the current characterPosition after eachThrow
     * {@link Character#getCharacterPosition()}
     * {@link character.Character#setCharacterPosition(int)}
     *
     *      Interact with the content of the cell only if there is a loot or an enemy
     * @see game.boardGame.cell
     *
     */
    public void currentCell(int diceResult) {
        // if the last throw outbound the boardGame, then i fix the characterPosition to 64
        if ((character.getCharacterPosition() + diceResult) > boardGame.getNumberOfCells()) {
            // This line determine the exact number to add in the Character Setter to get 64
            character.setCharacterPosition(boardGame.getNumberOfCells() - character.getCharacterPosition());
        } else {
            character.setCharacterPosition(diceResult);
        }
        System.out.println("Vous venez de lancer le d??, le r??sultat est : " + diceResult);
        System.out.println("Votre personnage est maintenant sur la case : " + character.getCharacterPosition() + "/" + boardGame.getNumberOfCells());
        List<Cell> cellList = boardGame.getBoardGame();
        // Check if there is an object in the List
        Cell cellContent = cellList.get(character.getCharacterPosition());
        if (cellContent != null) {
            cellContent.interaction(character, stuff);
        }
        System.out.println("");
        System.out.println(character.toString());
        System.out.println(stuff.toString());
    }

    /**
     * When player loot 2 weapon with the same force, he can choice one of the two
     * @return Boolean
     *      Return the choice of the user
     */
    public Boolean changeYourWeapon() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice == 2;
    }

    public void askForSaveCharacter() {
        ArrayList<String> allQuestions = new ArrayList<String>();
        allQuestions.add("Voulez-vous sauvegarder votre personnage ?");
        allQuestions.add("1 - OUI");
        allQuestions.add("2 - NON");
        int interactionWithUser = navigation.askQuestion(allQuestions);

        if (interactionWithUser == 1 && !restoredCharacter) {
            try {
                dataBase.saveCharacter(character.getClass().getSimpleName(), character.getName(), character.getLife(), character.getAttack(), character.getAttackEquipment().getEquipmentName(), character.getAttackEquipment().getEquipmentDamage(), character.getCharacterPosition(), this.difficultLevel);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if(interactionWithUser == 1 && restoredCharacter) {
            try {
                dataBase.updatePlayerInDB(character.getName(), character.getLife(), character.getAttack(), character.getAttackEquipment().getEquipmentName(), character.getAttackEquipment().getEquipmentDamage(), character.getCharacterPosition());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Vous avez chosis non");
        }
    }
}
