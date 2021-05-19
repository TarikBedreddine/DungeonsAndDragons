package menu;

import character.Character;
import character.Wizard;
import character.Warrior;
import game.Game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class handle all interactions with the user in the Menu
 *
 * @author Tarik
 *
 */
public class Navigation
{
    // All attributes
    Scanner scanner = new Scanner(System.in);

    // Method to start the menu & create a character

    /**
     * createCharacter permit to create a Warrior or a Wizard
     * {@link #createCharacter(Character)}
     *
     * Method System.exit kill the game
     *
     * @param character Character Object
     * @return Character
     *      Return the Character created
     *
     * @see Character
     *
     */
    public Character startMenu(Character character) {
        // Set user choice to 0
        int userAnswer = 0;
        // While the user don't leave the game, display the main menu
        while (userAnswer != 3 && userAnswer != 2 ) {
            System.out.println("");
            System.out.println(">>>>>>>>>>>>>>>>> 1 - CREER UN PERSONNAGE <<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>>>>>> 2 - CHARGER UN PERSONNAGE <<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>>>>>> 3 - LANCER LE JEU <<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>>>>>> 4 - QUITTER LE JEU <<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("");
            userAnswer = scanner.nextInt();
            scanner.nextLine();
            switch (userAnswer) {
                case 1: {
                    // CREATION OF THE CHARACTER
                    System.out.println(">>> Nous allons commencer la création d'un nouveau personnage <<<");
                    System.out.println("- Important : Pour le moment vous ne pouvez créer qu'un seul personnage -");
                    System.out.println("");
                    character = this.createCharacter(character);
                    this.subMenu(character);
                    break;
                }
                case 2 : {
                    break;
                }
                case 3: {
                    // RUN THE GAME
                    if (character == null) {
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("------ Impossible ! Vous n'avez pas créer de personnage -----");
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("------------- Retour au menu princiapl imminent -------------");
                        System.out.println("-------------------------------------------------------------");
                        userAnswer = 0;
                        break;

                    } else {
                        break;
                    }
                }
                case 4: {
                    // EXIT THE MENU
                    System.out.println("Merci de votre passage, au revoir !");
                    System.exit(0);
                    break;
                }
            }
        }
        return character;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////

    // Method to create the character and return it to the startMenu

    /**
     * Depending the answer of the user a Warrior or Wizard is created
     *
     * @param character Character
     *      A null character is given
     * @return Character
     *      It return an Object Character
     *
     * @see Character
     * @see Wizard
     * @see Warrior
     */
    public Character createCharacter (Character character) {
        int choice = 0;
        System.out.println("1- Guerrier");
        System.out.println("2- Magicien");
        choice = scanner.nextInt();
        scanner.nextLine();
        // If the input is not Guerrier or Magicien the scanner ask again for input
        while (choice != 1 && choice != 2) {
            System.out.println("Je n'ai pas compris votre choix");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        // Set name of the character
        System.out.println("Quel nom voulez-vous lui donner ?");
        String name = scanner.nextLine();

        if(choice == 1) {
            character = new Warrior(name, "none", 5, 5, 10, 10);
        } else {
            character = new Wizard(name, "none", 8, 3, 6, 15);
        }

        character.setName(name);
        return character;
    }

    /**
     * Sub menu :
     *      Display character information,
     *      Allow to change character name,
     *      Allow to leave the game
     *
     * @param character Character
     *      Represent the character which was created
     *
     * {@link Character}
     */
    public void subMenu(Character character) {
        int subMenuAnswer = 0;
        while (subMenuAnswer != 3) {
            switch (subMenuAnswer) {
                case 1: {
                    System.out.println(">>>>>>>> CARACTERISTIQUES DU PERSONNAGE <<<<<<<<<<");
                    System.out.println(">>>>>>>>>>>> Nom : " + character.getName());
                    System.out.println(">>>>>>>>>>>> Vie : " + character.getLife());
                    System.out.println(">>>>>>>>>> Attaque : " + character.getAttack());
                    break;
                }
                case 2: {
                    System.out.println("Ecrivez le nouveau nom de votre personnage");
                    String newName = scanner.nextLine();
                    String oldName = character.getName();
                    character.setName(newName);
                    System.out.println("Le personnage " + oldName + " devient .... " + newName);
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    System.out.println("Merci de votre passage, au revoir !");
                    System.exit(0);
                    break;
                }
            }
            System.out.println("------------------------------------------------------");
            System.out.println("1 - Afficher les caractéristiques de mon personnage");
            System.out.println("2 - Modifier le nom de mon personnage");
            System.out.println("3 - Menu principal");
            System.out.println("4 - Quitter le jeu");
            subMenuAnswer = scanner.nextInt();
            scanner.nextLine();
        }
    }

    /**
     * Ask to the user for a difficult level
     * @return String 
     *      String returned to the Game Class 
     * 
     * {@link game.boardGame.BoardGame#cellContent(String)}
     */
    public String difficultLevel() {
        System.out.println("");
        System.out.println("Choissisez un niveau de difficulté : ");
        System.out.println("1 - FACILE");
        System.out.println("2 - NORMAL");
        System.out.println("3 - DIFFICILE");

        int userAnswer = scanner.nextInt();
        scanner.nextLine();
        while (userAnswer != 1 && userAnswer != 2 && userAnswer!=3) {
            userAnswer = scanner.nextInt();
            scanner.nextLine();
        }
        if (userAnswer == 1) {
            return "Easy";
        } else if (userAnswer == 2 ) {
            return "Medium";
        }
        return "Hard";
    }

    public int askQuestion (ArrayList<String> allQuestions) {
        System.out.println("");
        for (int i = 0; i < allQuestions.size(); i++) {
            System.out.println("");
            System.out.println(allQuestions.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }


    /**
     * The user can start a new Game or leave the game
     * {@link Game#runGame()}
     *
     * @param character
     *      Represent the character which was created
     */
    public void leaveOrRestartGame(Character character) {
        System.out.println("--------------- 1 - Recommencer ------------------");
        System.out.println("----------------2 - Quitter --------------------");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            character = null;
            Game g = new Game();
            g.runGame();
        } else {
            System.exit(0);
        }
    }
}
