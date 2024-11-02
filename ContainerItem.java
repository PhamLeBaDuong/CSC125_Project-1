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
        boolean itemFound = false; 
        for(int i=0; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(itemName))
            {
              itemFound = true;
            }
        }
        return itemFound;

    }

    public Item removeItem(String itemName)
    {
        Item itemFound = null;
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equalsIgnoreCase(itemName))
            {
                items.remove(i); /// need recheck
                itemFound = items.get(i);
            }
        }
        return itemFound; /// need recheck
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

        for(int i = 0; i < items.size(); i++)
        {
            inventoryDes.append("+");
            inventoryDes.append(items.get(i).getName());
            inventoryDes.append("\n");
        }

        String inventoryDesStr = inventoryDes.toString();

        return inventoryDesStr;
    }

}

    

