// package CSC125_Project_1;

import java.util.ArrayList;

public class ContainerItem extends Item 
{
    private ArrayList<Item> items;
    
    public ContainerItem(String cName, String cType, String cDescription)
    {
       super(cName,cType,cDescription);
       items = new ArrayList<Item>();
    }

    public void addItem(Item pItem)
    {
        items.add(pItem);
    }
    
    public boolean hasItem(String itemName)
    {
        for(int i=0; i < items.size(); i++)
        {
            if(items.get(i).getName().equalsIgnoreCase(itemName))
            {
              return true;
            }
        }
        return false;

    }

    public Item removeItem(String itemName) {
        Item itemFound = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                itemFound = items.get(i);
                items.remove(i); 
            }
        }
        return itemFound; 
    }
    
    @Override
    public String toString()
    {
        StringBuilder inventoryDes = new StringBuilder();
        inventoryDes.append(getName());
        inventoryDes.append(" [ ");
        inventoryDes.append(getType());
        inventoryDes.append(" ] : ");
        inventoryDes.append(getDescription());
        inventoryDes.append("\n");

        if (items.isEmpty()) {
            inventoryDes.append("No items in inventory.\n");
        }
        else { 
            for(int i = 0; i < items.size(); i++)
            {
                inventoryDes.append("+ ");
                inventoryDes.append(items.get(i).getName());
                inventoryDes.append("\n");
            }
        }
        String inventoryDesStr = inventoryDes.toString();

        return inventoryDesStr;
    }

}

    

