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

}
