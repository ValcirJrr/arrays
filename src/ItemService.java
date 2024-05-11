package src;

import java.util.Scanner;
import java.util.function.Function;

public class ItemService {

    /*
    * The method bellow will receive a String Array and will expand it to a length + 1
    * And add to the last position the new Item description
    *
    * Needs to return a new String Array because we cannot change the array size
    * without create another memory pointer
    * */

    public String[] addItemToItems(String[] items, Scanner scanner){
        String itemName = waitForUserInformAName(scanner);
        String[] expandedArray = copyArray(items);
        addItemToArray(itemName, expandedArray);
        return expandedArray;
    }

    private String waitForUserInformAName(Scanner scanner) {
        System.out.println("Inform the item name: ");
        return scanner.nextLine();
    }

    private void addItemToArray(String itemName, String[] expandedArray) {
        expandedArray[expandedArray.length-1]= itemName;
    }

    private String[] copyArray(String[] items) {
        String[] expandedArray = new String[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            expandedArray[i] = items[i];
        }
        return expandedArray;
    }


}
