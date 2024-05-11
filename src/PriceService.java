package src;

public class PriceService {
    public double[] increaseArray(double[] prices){
        return increaseLengthAndCopyArray(prices);
    }

    private static double[] increaseLengthAndCopyArray(double[] prices) {
        double[] arrayToIncrease = new double[prices.length + 1];
        System.arraycopy(prices, 0, arrayToIncrease, 0, prices.length);
        return arrayToIncrease;
    }
}
