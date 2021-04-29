package menu;

import character.Magician;
import character.Warrior;

public class CreateCharacter {
    // This method permit to create an instance of the character & display his principal attributes
    public void createAndDisplayCharacter(String character, String name) {
        if (character.equalsIgnoreCase("Guerrier")) {
            // Instance of the Warrior class
            Warrior warriorIsSelected = new Warrior(name);
            // Store the name attribute
            String nameSelected = warriorIsSelected.getName();
            // Store the life attribute
            int life = warriorIsSelected.getLife();
            // Store the attack attribute
            int attack = warriorIsSelected.getAttack();
            // Display a message of the attributes
            System.out.println("Le nom de votre personnage est " + nameSelected + " il a " + life + " points de vie et " + attack + " d'attaque" );
        } else if (character.equalsIgnoreCase("Magicien")) {
            Magician magicianIsSelected = new Magician(name);
            String nameSelected = magicianIsSelected.getName();
            int life = magicianIsSelected.getLife();
            int attack = magicianIsSelected.getAttack();
            System.out.println("Le nom de votre personnage est " + nameSelected + " il a " + life + " points de vie et " + attack + " d'attaque" );
        }
    }
}
