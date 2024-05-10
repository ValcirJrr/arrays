package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        * The idea between the Arrays creation is to the items and prices represents
        * something like a restaurant menu, where the same position will refer to the same item and price
        * for example, if at items[1] = "coke" and prices[1] = 5.00, it means that in our restaurant menu
        * has a coke that costs $5.00
        *
        * The position 0 will not be used, because the orders matrix will be always fill blank spaces as 0
        * so, it represents that has no item.
        *
        * */
        String[] items = new String[1];
        double[] prices = new double[1];
        /*
        *  the orders matrix will have lines that represents orders and columns that represents item
        *  so
        *  1 2 0 0
        *  3 1 1 4
        *  2 0 0 0
        *
        * in this case we have three orders, the first one with two items, second with four items and the third
        * with just an item
        * */
        int[][] orders = new int[0][0];

        while (true){
            int selectedOption = showMenu(scanner);
            if(selectedOption == 0) break;
        }
    }

    private static int showMenu(Scanner scanner) {
        System.out.println("========== Menu ===========\n" +
                "1 - Add Item" +
                "2 - Price Item" +
                "3 - List Items" +
                "4 - New Order" +
                "5 - Order Item" +
                "6 - List Orders" +
                "7 - Finish Order");
        return scanner.nextInt();
    }
}
