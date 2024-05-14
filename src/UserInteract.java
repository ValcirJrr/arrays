package src;

import java.util.Scanner;

public class UserInteract {
    final String PRINT_PRODUCT = "%d - %s R$%.2f\n";
    final String REQUEST_ITEM_NAME = "Informe o nome do produto: ";
    final String REQUEST_ITEM_ID = "Informe o ID do item: ";
    final String REQUEST_ORDER_ID = "Informe o ID do pedido: ";
    final String REQUEST_ITEM_PRICE = "Informe o valor do Item";
    final String NEW_ORDER_INFO = "Pedido %d adicionado\n";

    final String MENU = """
                ========== Menu ===========
                1 - Nove produto
                2 - Precificar produto
                3 - Listar produtos
                4 - Novo pedido
                5 - Pedir Item
                6 - Listar Pedidos
                7 - Finalizar Pedido
                0 - Sair""";

    final String ORDER = "Pedido %d %n";

    final String LINE_BRAKER = "==================";

    public int showMenu(Scanner scanner) {
        System.out.println(MENU);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public String waitForUserInformAName(Scanner scanner) {
        System.out.println(REQUEST_ITEM_NAME);
        return scanner.nextLine();
    }

    public void printProducts(String[] items, double[] prices){
        for (int i = 1; i < items.length; i++) {
            System.out.printf(PRINT_PRODUCT, i, items[i], prices[i]);
        }
    }

    public int waitForItemID(Scanner scanner){
        System.out.println(REQUEST_ITEM_ID);
        final int itemID = scanner.nextInt();
        scanner.nextLine();
        return itemID;
    }

    public double waitForItemPrice(Scanner scanner){
        System.out.println(REQUEST_ITEM_PRICE);
        final double itemPrice = scanner.nextDouble();
        scanner.nextLine();
        return itemPrice;
    }

    public int waitForOrderID(Scanner scanner){
        System.out.println(REQUEST_ORDER_ID);
        final int orderID = scanner.nextInt();
        scanner.nextLine();
        return orderID;
    }

    public void newOrderInfo(int[][] orders){
        System.out.printf(NEW_ORDER_INFO, orders.length);
    }

    public  void listOrders(String[] items, double[] prices, int[][] orders) {
        for (int i = 0; i < orders.length; i++) {
            System.out.printf(ORDER, i);
            for (int j = 0; j < orders[i].length; j++) {
                if(orders[i][j] != 0)
                    System.out.printf(PRINT_PRODUCT, j ,items[orders[i][j]], prices[orders[i][j]]);
            }
            System.out.println(LINE_BRAKER);
        }
    }

    public int waitForOrderIDFromOrderList(Scanner scanner, int[][] orders) {
        System.out.println("Qual pedido deseja fechar?");
        for (int i = 0; i < orders.length; i++) {
            if(i == orders.length - 1) System.out.println(i);
            else System.out.print(i + ", ");
        }
        final int orderID = scanner.nextInt();
        scanner.nextLine();
        return orderID;
    }

    public void printOrderFromOrderList(int orderID, int[][] orders, String[] items, double[] prices) {
        double total = 0;
        for (int i = 0; i < orders[orderID].length; i++) {
            System.out.printf(PRINT_PRODUCT, i, items[orders[orderID][i]], prices[orders[orderID][i]]);
            total+=prices[orders[orderID][i]];
        }
        System.out.println(LINE_BRAKER);
        System.out.println("Total: " + total);
    }

    public boolean confirmOrderClose(Scanner scanner) {
        System.out.println("Deseja efetuar o pagamento? (S - N)");
        return scanner.nextLine().equalsIgnoreCase("S");
    }
}
