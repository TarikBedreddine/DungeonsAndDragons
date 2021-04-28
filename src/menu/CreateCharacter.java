package menu;

import character.Magician;
import character.Warrior;

public class CreateCharacter {

    public void createCharacter(String whichCharacter, String name) {
        if (whichCharacter == "Warrior") {
            Warrior warriorIsSelected = new Warrior(name);
        } else {
            Magician magicianIsSelected = new Magician(name);

        }
    }


}
