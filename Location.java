import java.util.ArrayList;

public class Location {

    private String locationName;
    private String locationDescription;
    private ArrayList<Item> inventory;

    //Constructor
    public Location(String locationName, String locationDescription) {
        locationName = new String();
        locationDescription = new String();
        inventory = new ArrayList<Item>();
    }

    //Getters
    public String getLocName() {
        return locationName;
    }

    public String getLocDescription() {
        return locationDescription;
    }

    //Setters
    public void setLocName(String locationName) {
        this.locationName = locationName;
    }

    public void setLocDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    //Specific Methods
    public void addItem(Item x) {
        inventory.add(x);
    }

    public boolean hasItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public Item getItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemName().equalsIgnoreCase(itemName)) {
                return inventory.get(i);
            }
        }
        return null;
    }

    public Item getItem(int x) {
        if (x < inventory.size()) {
            return inventory.get(x);
        }
        else {
            return null;
        }
    }

    public int numItems() {
        return inventory.size();
    }

    public Item removeItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemName().equalsIgnoreCase(itemName)) {
                Item foundItem = inventory.get(i);
                inventory.remove(i);
                return foundItem;
            }
        }
        return null;
    }
}