package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("========== Menu ===========\n" +
                    "1 - Add Item" +
                    "2 - Price Item" +
                    "3 - List Items" +
                    "4 - New Order" +
                    "5 - Order Item" +
                    "6 - List Orders" +
                    "7 - Finish Order");

            int selectedOption = scanner.nextInt();
            if(selectedOption == 0) break;
        }
    }
}
