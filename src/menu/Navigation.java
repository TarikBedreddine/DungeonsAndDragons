package menu;
import java.util.Arrays;
import java.util.Scanner;

public class Navigation
{

    public static String[] userChoices () {
        String[] allChoices = new String[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Magicien ou Guerrier ? ");
        allChoices[0] = scanner.nextLine();
        System.out.println("Quel nom voulez-vous lui donner ?");
        allChoices[1] = scanner.nextLine();
        return allChoices;
    }




    public static void main (String[] args ) {
        String[] userChoice = userChoices();
        System.out.println(userChoice[1]);
        //CreateCharacter newCharacter = new CreateCharacter(userChoice, );
    }



}
