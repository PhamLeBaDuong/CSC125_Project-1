import java.util.Scanner;

/**
 * The Driver class
 * @author Duong_Pham
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

            if(command.equalsIgnoreCase("quit")) {
                break;
            }
        }
    }
}