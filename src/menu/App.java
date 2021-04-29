package menu;

public class App {

    // Constructor of the App Class
    public void App () {

    }

    // Main entry point of the project
    public static void main (String[] args ) {
        // instance of the navigation class to use the userChoices method
        Navigation userChoices = new Navigation();
        // Store in an array the return of userChoices method
        String[] allUserChoices = userChoices.userChoices();
        // Instance of CreateCharacter class constructor
        CreateCharacter character = new CreateCharacter();
        // Method of the CreateCharacter class that permit to retrieve all attributes of the character
        character.createAndDisplayCharacter(allUserChoices[0], allUserChoices[1]);
    }
}

