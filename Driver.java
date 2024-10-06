import java.util.Scanner;

/**
 * The Driver class
 * @author Duong Pham, Anh Vu
 */

public class Driver {
    public static Location currLocation;
    public static void main(String[] args) {
        currLocation = new Location("Kitchen", "A dark kitchen whose lights are flickering");
        Item knifeItem = new Item("Knife", "Tool", "Dismantle and Cleave");
        Item turkeyItem = new Item("Turkey", "Food", "Eat");
        Item plateItem = new Item("Plate", "Utensils", "Below the food");
        currLocation.addItem(knifeItem);
        currLocation.addItem(turkeyItem);
        currLocation.addItem(plateItem);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] splttedCommand = command.split(" ");

            switch (splttedCommand[0].toLowerCase()) {
                case (" "):
                case ("quit"):
                    break;
                case ("look"):
                    System.out.print(currLocation.getLocName());
                    System.out.println(currLocation.getLocDescription());
                    for (int i = 0; i < currLocation.numItems(); i += 1) {
                        System.out.println(currLocation.getItem(i));
                    }
                    break;
                case ("examine"):
                    Item itemFound = (splttedCommand.length < 1) 
                        ? currLocation.getItem(splttedCommand[1])
                        : null;
                    if (itemFound == null) {
                        System.out.println("Cannot find that item");
                    }
                    else {
                        System.out.print(itemFound.getName());
                        System.out.print(itemFound.getDescription());
                    }
                default: 
                    System.out.println("I dont know how to do that");
            }
        }
    }
}