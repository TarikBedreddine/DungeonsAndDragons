package menu;
import character.Wizard;
import character.Warrior;

import java.util.Scanner;

public class Navigation
{
    // All attributes
    private String character;
    Scanner scanner = new Scanner(System.in);

    // Method to instance a Character and display information of the character
    public void createAndDisplayCharacter(String character, String name) {
        if (character.equalsIgnoreCase("Guerrier")) {
            // Instance of the Warrior class
            Warrior warriorIsSelected = new Warrior(name, "none", 5, 5);
            // Store the name attribute
            String nameSelected = warriorIsSelected.name();
            // Store the life attribute
            int life = warriorIsSelected.life();
            // Store the attack attribute
            int attack = warriorIsSelected.attack();
            // Display a message of the attributes
            System.out.println("Le nom de votre personnage est " + nameSelected + ", il a " + life + " points de vie et " + attack + " d'attaque" );
        } else if (character.equalsIgnoreCase("Magicien")) {
            Wizard wizardIsSelected = new Wizard(name, "none", 3, 8);
            String nameSelected = wizardIsSelected.name();
            int life = wizardIsSelected.life();
            int attack = wizardIsSelected.attack();
            System.out.println("Le nom de votre personnage est " + nameSelected + ", il a " + life + " points de vie et " + attack + " d'attaque" );
        }
    }

    // Set the value of character (Warrior or Wizard)
    public void setCharacter(String whichCharacter) {
        this.character = whichCharacter;
    }
    // Get the value of the attribute character
    public String getCharacter() {
        return character;
    }

    // This method permit to execute all the methods of the navigation class
    public void startMenu() {
        // Ask the user to start or end the game
        System.out.println("1 - Commencer le jeu || 2 - Quitter le jeu (Veuillez saisir 1 ou 2)" );
        int userAnswer = scanner.nextInt();
        // While the user doesn't leave the game, he can create an other character
        while (userAnswer == (1)) {
            System.out.println("--------------------------------------------------------------" );
            System.out.println("Nous allons commencer la création d'un nouveau personnage !" );
            // Store in an array the return of userChoices method
            String[] allUserChoices = userChoices();
            // Method of the CreateCharacter class that permit to retrieve all attributes of the character
            createAndDisplayCharacter(allUserChoices[0], allUserChoices[1]);
            // Offer the possibility for the user to change the name of the character
            modifyNameChoice();
            // Ask the user to start or end the game
            System.out.println("1 - Commencer le jeu || 2 - Quitter le jeu (Veuillez saisir 1 ou 2)" );
            userAnswer = scanner.nextInt();
        }
        // method to end the game
        leaveMenu();
    }
    // This method will get the character & name chosen by the user. The return is an String array
    public String[] userChoices () {
        String[] allChoices = new String[2];
        // Scan the input of the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Magicien ou Guerrier ? ");
        allChoices[0] = scanner.nextLine();
        // If the input is not Warrior or Wizard the scanner ask again for an other input
        while (!allChoices[0].equalsIgnoreCase("Guerrier") && !allChoices[0].equalsIgnoreCase("Magicien")) {
            System.out.println("Magicien ou Guerrier ? ");
            // Store the name of the character chosen at the index 1 of the allChoices array
            allChoices[0] = scanner.nextLine();

        }
        System.out.println("Quel nom voulez-vous lui donner ?");
        allChoices[1] = scanner.nextLine();
        setCharacter(allChoices[0]);
        return allChoices;
    }

    // This method permit to modify the name of the character
    public void modifyNameChoice () {
        String character = getCharacter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous changer le nom de votre personnage ? (Oui ou Non)");
        String userAnswer = scanner.nextLine();
        while (!userAnswer.equalsIgnoreCase("Oui") && !userAnswer.equalsIgnoreCase("Non")) {
            System.out.println("Veuillez répondre par OUI ou par NON s'il vous plaît ?");
            userAnswer = scanner.nextLine();
        }
        if(userAnswer.equalsIgnoreCase("Oui")) {
            System.out.println("Veuillez saisir le nouveau nom !");
            String newName = scanner.nextLine();
            createAndDisplayCharacter(character, newName);
        } else {
            System.out.println("C'est noté ! le nom de votre personnage reste inchangé");
        }
    }

    // This method permit to the use to end the game
    public void leaveMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Etes vous sûr de vouloir quitter ? (Oui ou Non)");
        String userAnswer = scanner.nextLine();
        while (!userAnswer.equalsIgnoreCase("Oui") && !userAnswer.equalsIgnoreCase("Non")) {
            System.out.println("Répondez par OUI ou NON s'il vous plaît ?");
            userAnswer = scanner.nextLine();
        }
        if(userAnswer.equalsIgnoreCase("Oui")) {
            System.out.println("Merci de votre passage, au revoir !");
            System.exit(0);

        } else {
            System.out.println("Super ! poursuivons notre aventure !");
            startMenu();
        }
    }

    // This method will start the game
    public void startGame() {
        System.out.println("Le jeu va débuter, vous êts prêts ?");

    }
}
