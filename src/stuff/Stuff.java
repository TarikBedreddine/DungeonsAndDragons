package stuff;

import java.util.ArrayList;

public class Stuff {
    private String name;
    private ArrayList<Object> stuffType;

    public Stuff(String nameOfTheStuff) {
        this.name = nameOfTheStuff;
        this.stuffType = new ArrayList<>(3);
    }

    public void addItemToBackpack (Object itemToAdd) {
        this.stuffType.add(itemToAdd);
    }

    public void retrieveAnItemToUseIt(String objectToRetrieve) {
        for (int i = 0; i < stuffType.size(); i++) {

        }
    }








    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Object> getStuffType() {
        return stuffType;
    }

    public void setStuffType(ArrayList<Object> stuffType) {
        this.stuffType = stuffType;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < stuffType.size(); i++) {
            s += "Stuff numéro " + (i + 1) + " ------ " + stuffType.get(i) + "\n";
            }
        return s;
    }
}
