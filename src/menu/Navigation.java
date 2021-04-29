package menu;
import java.util.Arrays;
import java.util.Scanner;

public class Navigation
{
    // All attributes
    private String character;
    Scanner scanner = new Scanner(System.in);

    // Set the value of character (Warrior or magician)
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
            // Instance of CreateCharacter class constructor
            CreateCharacter character = new CreateCharacter();
            // Method of the CreateCharacter class that permit to retrieve all attributes of the character
            character.createAndDisplayCharacter(allUserChoices[0], allUserChoices[1]);
            // Offer the possibility for the user to change the name of the character
            modifyNameChoice();
        }
        // method to end the game
        leaveGame();
    }
    // This method will get the character & name chosen by the user. The return is an String array
    public String[] userChoices () {
        String[] allChoices = new String[2];
        // Scan the input of the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Magicien ou Guerrier ? ");
        allChoices[0] = scanner.nextLine();
        // If the input is not Warrior or Magician the scanner ask again for an other input
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
            CreateCharacter applyModification = new CreateCharacter();
            applyModification.createAndDisplayCharacter(character, newName);
        } else {
            System.out.println("C'est noté ! le nom de votre personnage reste inchangé");
        }
    }

    // This method permit to the use to end the game
    public void leaveGame() {
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
        }
    }
}
