import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Location class is used to encapsulate information about a single location in the game
 * @author Anh Vu, Duong Pham, Devin Best, Evan Lambert
 * @version October 2024
 * @version November 2024
 */

public class Location {

    private String locationName;
    private String locationDescription;
    private ArrayList<Item> inventory;
    private HashMap<String,Location> connections; 

    /**
     * The constructer used to construct a new Location from name and description information. The inventory 
     * ArrayList contain the Item objects at the location
     * @param locationName Name of the location
     * @param locationDescription Description of the location
     */
    public Location(String locationName, String locationDescription) 
    {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        inventory = new ArrayList<Item>();
        connections = new HashMap<String,Location>();
    }

    /**
    * This method returns name of the location
    * @return String - name of the location
    */
    public String getLocName() {
        return locationName;
    }

    /**
    * This method returns description of the location 
    * @return String - description of the location
    */
    public String getLocDescription() {
        return locationDescription;
    }

    /**
    * This method sets the name of the location
    * @param locationName New name of the location
    */
    public void setLocName(String locationName) {
        this.locationName = locationName;
    }

    /**
    * This method sets the description of the location
    * @param locationDescription New description of the location
    */
    public void setLocDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    /**
    * This method add the Item object to the location’s ArrayList of stored items
    * @param item Item object you want to add
    */
    public void addItem(Item item) {
        inventory.add(item);
    }

    /**
    * This method search fpr the Item object from the location’s ArrayList of stored items
    * @param itemName Name of the item you want to search for
    * @return Boolean - return true if the item is found and false if not
    */
    public boolean hasItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    /**
    * This method check to see if an Item with that name is in the ArrayList and if so, return the matching Item object
    * @param itemName Name of the item you want to get
    * @return Item - the matching Item object if found, null if not
    */
    public Item getItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName)) {
                return inventory.get(i);
            }
        }
        return null;
    }

    /**
    * This method returns the Item object in the Location’s ArrayList at a particular index
    * @param index Index at which Item object you want to get
    * @return: Item - the Item object if found at that index, null if out of bound
    */
    public Item getItem(int index) {
        if (index < inventory.size()) {
            return inventory.get(index);
        }
        else {
            return null;
        }
    }

    /**
    * This method returns how many items are in the location’s ArrayList
    * @return int - size of the location’s ArrayList
    */
    public int numItems() {
        return inventory.size();
    }

    /**
    * This method checks to see if an Item with that name is in the ArrayList and if so, remove and return the matching Item object,
    * @param itemName Name of the item you want to return
    * @return Item - Matching Item object that was removed
    */
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
    
    public void connect(String dirctName,Location Location)
    {
        connections.put(dirctName,Location);
    }

    public boolean canMove(String dirctName)
    {
        Location temp = connections.get(dirctName);
        if(temp == null)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Location getLocation(String dirctName)
    {
        return connections.get(dirctName);

    }
}