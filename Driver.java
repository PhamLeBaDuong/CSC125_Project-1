import java.util.Scanner;

/**
 * The Driver class contains an “infinite” loop that continuously prompts the user for the next command and reacts to what they type
 * @author Anh Vu, Duong Pham, Devin Best, Evan Lambert
 * @version October 2024
 */

public class Driver {
    public static Location currLocation;
    public static ContainerItem myInventory;

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

        createWorld();

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
                case("go west"):
                    currLocation.getLocation("west");
                    if(currLocation == null) {
                        System.out.println("Cannot go that way");
                    }
                    else {
                        currLocation = currLocation.getLocation("west");
                    }
                    break;
                case("go east"):
                    currLocation.getLocation("east");
                    if(currLocation == null) {
                        System.out.println("Cannot go that way");
                    }
                    else {
                        currLocation = currLocation.getLocation("east");
                    }
                    break;
                case("go north"):
                    currLocation.getLocation("north");
                    if(currLocation == null) {
                        System.out.println("Cannot go that way");
                    }
                    else {
                        currLocation = currLocation.getLocation("north");
                    }
                    break;
                case("go south"):
                    currLocation.getLocation("south");
                    if(currLocation == null) {
                        System.out.println("Cannot go that way");
                    }
                    else {
                        currLocation = currLocation.getLocation("south");
                    }
                    break;
                case("inventory"):
                    ///Print list of item (names-only) that are currently stored in the character's inventory
                case("take"):
                    ///Try to find the matching item at the current location, if found, remove from location and add to inventory, if not print "Cannot find that item here" 
                case("drop"):
                    ///Try to find the matching item in the character's inventory, remove it and add to the current location
                case("help"):
                    ///Print all the commands currently supported with a one-sentence description
                case ("quit"):
                    System.exit(0);
                    break;
                default: 
                    System.out.println("Unknown command");
            }
        }
    }
    public static void createWorld() {
        Location kitchen = new Location("Kitchen", "A dark kitchen whose lights are flickering");
        Location hallway = new Location("Hallway", "A long line");
        Location bedroom = new Location("Bedroom", "A place for rest");
        Location livingroom = new Location("Livingroom", "Not a living room");

        Item knifeItem = new Item("Knife", "Tool", "Dismantle and Cleave, with a huge red stain on it, likely blood");
        Item turkeyItem = new Item("Turkey", "Food", "Some leftover turkey, smells terrible, likely rotten");
        Item lambItem = new Item("Lamb", "Decoration", "A lame lamb that lights the room");
        Item tablItem = new Item("Table", "Decoration", "A thing that is below everything");
        Item carpetItem = new Item("Carpet", "Decoration", "A thing that seperate the dirt from your feet and the floor");

        kitchen.addItem(knifeItem);
        kitchen.addItem(turkeyItem);
        bedroom.addItem(lambItem);
        livingroom.addItem(tablItem);
        hallway.addItem(carpetItem);

        kitchen.connect("west", bedroom);
        bedroom.connect("north", hallway);
        hallway.connect("east", livingroom);
        livingroom.connect("west", hallway);
        hallway.connect("north", kitchen);

        currLocation = kitchen;
    }
}