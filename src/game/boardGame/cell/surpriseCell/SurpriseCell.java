package game.boardGame.cell.surpriseCell;

import game.boardGame.cell.Cell;
import game.boardGame.cell.shieldCell.BigPotion;
import game.boardGame.cell.shieldCell.StandardPotion;
import character.Character;
import game.boardGame.cell.weapon.Club;
import game.boardGame.cell.weapon.Fireball;
import game.boardGame.cell.weapon.Sword;
import game.boardGame.cell.weapon.Thunderbolt;

public class SurpriseCell extends Cell {

    // Attributes


    // Constructors
    public SurpriseCell() {

    }

    public void randomSurprise(Character character) {
        int range = (6 - 1) + 1;
        int randomResult = (int)(Math.random() * range) + 1;
        switch (randomResult) {
            case 1: {
                StandardPotion standardPotion = new StandardPotion();
                System.out.println("");
                System.out.println("Vous obtenez une potion standard !!!");
                System.out.println("");
                standardPotion.interaction(character);
                break;
            }
            case 2: {
                BigPotion bigPotion = new BigPotion();
                System.out.println("");
                System.out.println("Vous obtenez la grande Potion, quel chanceux !!!");
                System.out.println("");
                bigPotion.interaction(character);
                break;
            }
            case 3: {
                Club club = new Club();
                System.out.println("");
                System.out.println("Vous obtenez une massue, avec ça vous n'avez plus d'excuses !!!");
                System.out.println("");
                club.interaction(character);
                break;
            }
            case 4: {
                Fireball fireball = new Fireball();
                System.out.println("");
                System.out.println("Vous obtenez une boule de feu, à ce stade, vous êtes quasiement invisible ...");
                System.out.println("");
                fireball.interaction(character);
                break;
            }
            case 5: {
                Sword sword = new Sword();
                System.out.println("");
                System.out.println("Vous obtenez une épée, faites en bon usage !!!");
                System.out.println("");
                sword.interaction(character);
                break;
            }
            case 6: {
                Thunderbolt thunderbolt = new Thunderbolt();
                System.out.println("");
                System.out.println("Vous obtenez l'éclair, la partie n'est elle pas gagné ?");
                System.out.println("");
                thunderbolt.interaction(character);
                break;
            }
        }
    }

    // Methods
    @Override
    public void interaction(Character character) {
        System.out.println("");
        System.out.println("Oh yes ! une caisse surprise ...");
        randomSurprise(character);
    }

    // Getters & Setters
}
