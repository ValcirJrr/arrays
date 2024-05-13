package src;

public class OrderService {

    public int[][] increaseOrderArray(int[][] orders) {
        if (doestHasAnyOrder(orders)) {
            return new int[1][1];
        }
        int[][] extendedArray = new int[orders.length + 1][orders[0].length];
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length; j++) {
                addItemToIPosition(orders[i][j], j, extendedArray[i]);
            }
        }
        return extendedArray;
    }

    public int[][] addItemToOrder(int[][] orders, int itemPosition, int orderPosition) {
        if (doestHasAnyOrder(orders)) return orders;
        for (int i = 0; i < orders[orderPosition].length; i++) {
            if (hasSpaceWithNoCodeItem(i, orders[orderPosition]))
                addItemToIPosition(itemPosition, i, orders[orderPosition]);
            else if (hasNoMoreBlankSpaces(i, orders[orderPosition])) {
                int[][] newOrders = createANewArrayWirhSecondStagePostionPlusOne(orders, orderPosition);
                copyPreviousToNewArray(orders, newOrders);
                addItemToNewOrdersLastPosition(itemPosition, newOrders[orderPosition]);
                return newOrders;
            }
        }
        return orders;
    }

    private static boolean hasNoMoreBlankSpaces(int i, int[] orders) {
        return i == (orders.length - 1);
    }

    private void addItemToIPosition(int itemPosition, int i, int[] orders) {
        orders[i] = itemPosition;
    }

    private boolean hasSpaceWithNoCodeItem(int i, int[] orders) {
        return orders[i] == 0;
    }

    private int[][] createANewArrayWirhSecondStagePostionPlusOne(int[][] orders, int orderPosition) {
        return new int[orders.length][(orders[orderPosition].length + 1)];
    }

    private void addItemToNewOrdersLastPosition(int itemPosition, int[] newOrders) {
        addItemToIPosition(itemPosition, newOrders.length - 1, newOrders);
    }

    private void copyPreviousToNewArray(int[][] orders, int[][] newOrders) {
        for (int j = 0; j < newOrders.length; j++) {
            for (int k = 0; k < newOrders[j].length; k++) {
                addItemToIPosition(orders[j][k], k, newOrders[j]);
            }
        }
    }

    private boolean doestHasAnyOrder(int[][] orders) {
        return orders.length < 1;
    }

}
