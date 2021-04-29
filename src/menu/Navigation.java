package menu;
import java.util.Arrays;
import java.util.Scanner;

public class Navigation
{
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
        // Store the value of the name at the index 1 of the allChoices array
        allChoices[1] = scanner.nextLine();
        return allChoices;
    }



    // Main entry point of the project
    public static void main (String[] args ) {
        // instance of the navigation class to use the userChoices method
        Navigation userChoices = new Navigation();
        // Store in an array the retrun of userChoices method
        String[] allUserChoices = userChoices.userChoices();
        // Instance of CreateCharacter class constructor
        CreateCharacter character = new CreateCharacter();
        // Method of the CreateCharacter class that permit to retrieve all attributes of the character
        character.createAndDisplayCharacter(allUserChoices[0], allUserChoices[1]);
    }
}
