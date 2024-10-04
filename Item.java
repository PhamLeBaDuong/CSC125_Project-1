/**
 * The Item class is used to encapsulate information about an item in the game
 * @author Anh Vu
 */
public class Item {
    private String name;
    private String type;
    private String description;

    /**
     * The constructer used to construct a new Item from name, type and description information
     * @param pName Name of the item
     * @param pType Type of the item
     * @param pDescription Description of the item
     */
    public Item(String pName, String pType, String pDescription) {
        name = pName;
        type = pType;
        description = pDescription;
    }

    /**
    * This method returns name of the item 
    * @return String contain the name of the item
    */
    public String getName() {
        return name;
    }

    /**
    * This method returns the type of the item 
    * @return String contain the type of the item
    */
    public String getType() {
        return type;
    }

    /**
    * This method returns description of the item 
    * @return String contain the description of the item
    */
    public String getDescription() {
        return description;
    }
}