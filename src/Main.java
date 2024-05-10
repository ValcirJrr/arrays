package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
