package be.rd.structures.arrays;

/**
 * Created by ruben on 6/9/14.
 */
public class MatrixMultiplicationTest {

    /**matrix one: gross income per fruit per city
    *
    *               |oranges    | peaches   | grapefruit
    * New York      |   10      |   8       |   12
    * Los Angeles   |   11      |   8.50    | 11.55
    * Miami         |   8.75    |   6.90    | 10
    * Chicago       |   10.50   |   8.25    |   11.75
    */
    private static double[][] marketPricesArr = new double[][]{{10,8,12},{11,8.50,11.55}, {8.75,6.90,10}, {10.50,8.25,11.75}};

    /**
     * The amount of fruits
     * oranges      : 1250
     * peaches      : 400
     * grapefruit   : 250
     */
    private static double[] amountOfFruitsPerSort = new double[]{1250, 400, 250};

    public static void main(String[] args)
    {
        /**calc the max gross income to send all thrailers to same location*/
        double[] grossIncomePerCity = multiplyMatrix(marketPricesArr, amountOfFruitsPerSort);
        for(double cur : grossIncomePerCity)
        {
            log(cur);
        }
    }

    private static double[] multiplyMatrix(double[][] arrA, double[] arrB)
    {
        double[] arrC = new double[arrA.length];

        // loop over rows of arrA (cities)
        for(int cityIdx = 0; cityIdx < arrA.length; cityIdx++)
        {

            double[] pricePerFruitInCity = arrA[cityIdx];

            arrC[cityIdx] = 0d;
            // loop over fruits
            for(int fruitIdx = 0; fruitIdx < pricePerFruitInCity.length ; fruitIdx++)
            {
                double price = pricePerFruitInCity[fruitIdx];
                double amount = arrB[fruitIdx];
                arrC[cityIdx] += (price * amount);
            }
        }
        return arrC;
    }

    private static void log(int aMessage){
        System.out.println(aMessage);
    }

    private static void log(Object aMessage){
        System.out.println(aMessage);
    }

    private static void log(String aMessage){
        System.out.println(aMessage);
    }
}
