package src;

import java.util.Scanner;

public class UserInteract {
    final String PRINT_PRODUCT = "%d - %s R$%.2f\n";
    final String REQUEST_ITEM_NAME = "Informe o nome do produto: ";
    final String REQUEST_ITEM_ID = "Informe o ID do item: ";
    final String REQUEST_ITEM_PRICE = "Informe o valor do Item";
    final String NEW_ORDER_INFO = "Pedido %d adicionado\n";

    public int showMenu(Scanner scanner) {
        System.out.println("""
                ========== Menu ===========
                1 - Nove produto
                2 - Precificar produto
                3 - Listar produtos
                4 - Novo pedido
                5 - Pedir Item
                6 - Listar Pedidos
                7 - Finalizar Pedido
                0 - Sair""");
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
        return scanner.nextInt();
    }

    public double waitForItemPrice(Scanner scanner){
        System.out.println(REQUEST_ITEM_PRICE);
        return scanner.nextDouble();
    }

    public void newOrderInfo(int[][] orders){
        System.out.printf(NEW_ORDER_INFO, orders.length);
    }
}
