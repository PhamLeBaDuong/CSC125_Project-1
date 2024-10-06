import java.util.ArrayList;

public class Location {

    private String locationName;
    private String locationDescription;
    private ArrayList<Item> inventory;

    //Constructor
    public Location(String locationName, String locationDescription) {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
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
    public void addItem(Item item) {
        inventory.add(item);
    }

    public boolean hasItem(String itemName) {
        boolean itemFound = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName)) {
                itemFound = true;
            }
        }
        return itemFound;
    }

    public Item getItem(String itemName) {
        Item foundItem = null;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName)) {
                foundItem = inventory.get(i);
            }
        }
        return foundItem;
    }

    public Item getItem(int index) {
        if (index < inventory.size()) {
            return inventory.get(index);
        }
        else {
            return null;
        }
    }

    public int numItems() {
        return inventory.size();
    }

    public Item removeItem(String itemName) {
        Item foundItem = null;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName)) {
                foundItem = inventory.get(i);
                inventory.remove(i);
            }
        }
        return foundItem;
    }
}