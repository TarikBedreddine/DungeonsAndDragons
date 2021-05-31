package stuff;

import java.util.ArrayList;

public class Stuff {
    private String name;
    private ArrayList<Object> stuffType;

    public Stuff(String nameOfTheStuff) {
        this.name = nameOfTheStuff;
        this.stuffType = new ArrayList<>(10);
        for (int i = 0; i <= 10; i++) {
            stuffType.add("-----------------");
        }

    }

    public void addItemToBackpack (Object itemToAdd, String nameOfItem) {
        for (int i = 0; i < stuffType.size(); i++) {
            if (stuffType.get(i) instanceof String) {
                this.stuffType.set(i, itemToAdd);
                System.out.println("Vous stocker " + nameOfItem+ " dans votre inventaire :)");
                break;
            }
        }
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
            s += "Stuff " + (i + 1) + " --- " + stuffType.get(i) + "\n";
            }
        return s;
    }
}
