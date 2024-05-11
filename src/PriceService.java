package src;

import java.util.Scanner;
import java.util.function.Function;

public class PriceService {

    public double[] increaseArray(double[] prices){
        return increaseLengthAndCopyArray(prices);
    }

    public void priceAnItem(double[] prices, int itemID, double itemPrice){
        prices[itemID] = itemPrice;
    }

    private double[] increaseLengthAndCopyArray(double[] prices) {
        double[] arrayToIncrease = new double[prices.length + 1];
        System.arraycopy(prices, 0, arrayToIncrease, 0, prices.length);
        return arrayToIncrease;
    }
}
