package equipment;

public class attackEquipment {

    // Attributes
    private String type;
    private String equipmentName;
    private int equipmentDamage;

    // Constructors
    public attackEquipment() {
        this.type = "";
        this.equipmentName = "";
        this.equipmentDamage = 0;
    }

    // Getters & Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

}
