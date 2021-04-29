package menu;
import java.util.Arrays;
import java.util.Scanner;

public class Navigation
{
    // All attributes
    private String character;

    // Set the value of character (Warrior or magician)
    public void setCharacter(String whichCharacter) {
        this.character = whichCharacter;
    }
    // Get the value of the attribute character
    public String getCharacter() {
        return character;
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

    public void modifyNameChoice () {
        String character = getCharacter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous changer le nom de votre personnage ? (Oui ou Non)");
        String userAnswer = scanner.nextLine();
        if(userAnswer.equalsIgnoreCase("Oui")) {
            System.out.println("Veuillez saisir le nouveau nom !");
            String newName = scanner.nextLine();
            CreateCharacter applyModification = new CreateCharacter();
            applyModification.createAndDisplayCharacter(character, newName);
        } else {
            System.out.println("C'est noté ! le nom de votre personnage reste inchangé");
        }
    }
}
