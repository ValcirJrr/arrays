package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInteract userInteract = new UserInteract();
        ItemService itemService = new ItemService();
        PriceService priceService = new PriceService();
        OrderService orderService = new OrderService();

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
            int selectedOption = userInteract.showMenu(scanner);
            if(selectedOption == 0) break;
            switch (selectedOption) {
                case 1 -> {
                    String itemName = userInteract.waitForUserInformAName(scanner);
                    items = itemService.addItemToItems(items, itemName);
                    prices = priceService.increaseArray(prices);
                }
                case 2 -> {
                    userInteract.printProducts(items, prices);
                    int itemId = userInteract.waitForItemID(scanner);
                    double itemPrice = userInteract.waitForItemPrice(scanner);
                    priceService.priceAnItem(prices, itemId, itemPrice);
                }
                case 3 -> {
                    userInteract.printProducts(items,prices);
                }
                case 4 -> {
                    orders = orderService.increaseOrderArray(orders);
                    userInteract.newOrderInfo(orders);
                }
                case 5 -> {
                    int itemId = userInteract.waitForItemID(scanner);
                    int orderId = userInteract.waitForOrderID(scanner);
                    orders = orderService.addItemToOrder(orders, itemId, orderId);
                }
                case 6 -> {
                    userInteract.listOrders(items, prices, orders);
                }
                case 7 -> {
                    int orderID = userInteract.waitForOrderIDFromOrderList(scanner, orders);
                    userInteract.printOrderFromOrderList(orderID, orders, items, prices);
                    boolean confirm = userInteract.confirmOrderClose(scanner);
                    if(confirm) orders = orderService.payOrder(orders, orderID);
                }
            }
        }
    }

}
