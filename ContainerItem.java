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
            if(items.get(i).getName().equals(itemName))
            {
              return true;
            }
        }
        return false;

    }
    public Item removeItem(String itemName)
    {
    
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equalsIgnoreCase(itemName))
            {
                return items.remove(i);
            }

        }
        return null;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder(20);
        builder.append(getName());
        builder.append(" [ ");
        builder.append(getType());
        builder.append(" ] : ");
        builder.append(getDescription());
        String result = builder.toString();
        String result2 = new String();
        for(int i = 0; i < items.size(); i++)
        {
            result2 = result2 + "+ " + items.get(i).getName() + "\n";
            
        }

        String result3 = result + result2;

        return result3;

    }

}

    

