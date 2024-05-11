package src;

public class OrderService {

    public int[][] increaseOrderArray(int[][] orders){
        if(orders.length < 1){
            return new int[1][1];
        }
        int[][] extendedArray = new int[orders.length+1][orders[0].length];
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length; j++) {
                extendedArray[i][j] = orders[i][j];
            }
        }
        return extendedArray;
    }

    public int[][] addItemToOrder(int[][] orders, int itemPosition, int orderPosition){
        return new int[][]{};

    }

}
