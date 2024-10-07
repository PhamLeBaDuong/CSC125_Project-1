import java.util.Scanner;

/**
 * The Driver class contains an “infinite” loop that continuously prompts the user for the next command and reacts to what they type
 * @author Anh Vu, Duong Pham, Devin Best, Evan Lambert
 * @version October 2024
 */

public class Driver {
    public static Location currLocation;
    public static void main(String[] args) {
        ///Create and initialize "Kitchen" location
        currLocation = new Location("Kitchen", "A dark kitchen whose lights are flickering");

        Item knifeItem = new Item("Knife", "Tool", "Dismantle and Cleave, with a huge red stain on it, likely blood");
        Item turkeyItem = new Item("Turkey", "Food", "Some leftover turkey, smells terrible, likely rotten");
        Item plateItem = new Item("Plate", "Utensils", "A cracked ceramic plate, can be used to hold foods");
        currLocation.addItem(knifeItem);
        currLocation.addItem(turkeyItem);
        currLocation.addItem(plateItem);

        ///Scanner that reads its data from the standard input stream
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to The House");

        ///An “infinite” loop that continuously prompts the user for the next command and reacts to what they type
        while (true) {
            
            System.out.print("Enter command: ");

            String command = scanner.nextLine();
            String[] splttedCommand = command.split(" ");

            switch (splttedCommand[0].toLowerCase()) {
                case (""):
                    break;
                case ("look"):
                    System.out.print(currLocation.getLocName());
                    System.out.print(" - ");
                    System.out.println(currLocation.getLocDescription());
                    for (int i = 0; i < currLocation.numItems(); i += 1) {
                        System.out.println(currLocation.getItem(i));
                    }
                    break;
                case ("examine"):
                    if (splttedCommand.length != 2) {
                        System.out.println("Please specify the item you want to examine");
                    }
                    else {
                        Item itemFound = currLocation.getItem(splttedCommand[1]);
                        if (itemFound == null) {
                            System.out.println("Cannot find that item");
                        }
                        else {
                            System.out.println(itemFound.toString());
                        }
                    }
                    break;
                case ("quit"):
                    System.exit(0);
                    break;
                default: 
                    System.out.println("Unknown command");
            }
        }
    }
}