package game.boardGame.cell.attackEquipment;

import character.Character;
import game.boardGame.cell.Cell;
import stuff.Stuff;

/**
 * This Class represent the equipment of a character
 *
 * @author Tarik
 *
 * @see Cell
 *
 * Children Classes :
 * @see game.boardGame.cell.attackEquipment.weapon.Weapon
 * @see game.boardGame.cell.attackEquipment.spell.Spell
 *
 */
public class AttackEquipment implements Cell {

    // Attributes
    private String equipmentName;
    private int equipmentDamage;

    /**
     * Constructor
     * Initialize the equipmentName and equipmentDamage
     *
     * {@link game.boardGame.cell.attackEquipment.spell.Spell#Spell(String, int)}
     * {@link game.boardGame.cell.attackEquipment.weapon.Weapon#Weapon(String, int)}
     */
    public AttackEquipment(String equipmentName, int equipmentDamage) {
        this.equipmentName = equipmentName;
        this.equipmentDamage = equipmentDamage;
    }

    /**
     * Set the interaction method to allow children to use it
     *
     * @param character Character
     *      Character who will interact with this method
     *
     */
    @Override
    public void interaction(Character character, Stuff stuff) {

    }

    // Getters & Setters
    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getEquipmentDamage() {
        return equipmentDamage;
    }

    public void setEquipmentDamage(int equipmentDamage) {
        this.equipmentDamage = equipmentDamage;
    }

    @Override
    public String toString() {
        return "AttackEquipment{" +
                "equipmentName='" + equipmentName + '\'' +
                ", equipmentDamage=" + equipmentDamage +
                '}';
    }
}
