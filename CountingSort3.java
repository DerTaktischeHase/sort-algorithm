import java.util.Random;

/**
 * User: Timo
 * Date: 06.11.2023
 * Time: 22:54
 */
public class CountingSort3 {
    static int runtime = 0;
    private static final int MAX_VALUE_TO_SORT = Integer.MAX_VALUE / 2;
    private static final int MIN_VALUE_TO_SORT = Integer.MIN_VALUE / 2;
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Record start time in nanoseconds
        // Integer.MIN_VALUE = -2147483648 = -2^(31)
        // Integer.MAX_VALUE = +2147483647 = +2^(31)-1
        int[] arrayList = randomArrayList(0, 500, 5000); // the limit must be positive (example: 1, 500, 10)
        runtime = 0;

        sort(arrayList);

        // Record end time in nanoseconds
        final long endTime = System.nanoTime();

        // Calculate the elapsed time in seconds
        final double elapsedTimeInSeconds = (double) (endTime - startTime) / 1000000000;
        String formattedDuration = String.format("%.8f", elapsedTimeInSeconds);
        System.out.println("done...\n> " + arrayListToString(arrayList) + "\nruntime: (" + runtime + "/" + arrayList.length +
                "; efficiency: " + (double) runtime/ arrayList.length +") \nProcess finished in " + formattedDuration + " seconds");
    }

    public static void sort(int[] arrayList) {
        Limits limits = findLimits(arrayList);
        int[] countingArray = new int[limits.max - limits.min + 1];

        // #1
        for (int element : arrayList) {
            countingArray[element - limits.min]++;
            runtime++;
        }
        
        // #2
        int targetPos = 0;
        for (int i = 0; i < countingArray.length; i++) {
            for (int j = 0; j < countingArray[i]; j++) {
                arrayList[targetPos++] = i + limits.min;
                runtime++;
            }
        }
    }

    public static Limits findLimits(int[] arrayList) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : arrayList) {
            if (element > MAX_VALUE_TO_SORT) {
                throw new IllegalArgumentException("Element " + element +
                        " is greater than maximum " + MAX_VALUE_TO_SORT);
            }
            if (element < MIN_VALUE_TO_SORT) {
                throw new IllegalArgumentException("Element " + element +
                        " is less than minimum " + MIN_VALUE_TO_SORT);
            }
            if (element > max) {
                max = element;
            }
            if (element < min) {
                min = element;
            }
            runtime++;
        }
        return new Limits(min, max);
    }

    public static class Limits {
        private final int min;
        private final int max;

        public Limits(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static int[] randomArrayList (int lowestValue, int highestValue, int length) {
        int[] arrayList = new int[length];
        Random random = new Random();

        // the limit must be positive
        //if (lowestValue < 1) lowestValue = 1;
        //if (highestValue < 1) highestValue = 1;
        if (lowestValue > highestValue) highestValue = lowestValue;
        for (int i = 0; i < length; i++) {

//          random.nextInt(n) erzeugt eine Zufallszahl zwischen 0 (inklusiv) und n (exklusiv).
//          In diesem Fall ist n gleich highestValue - lowestValue + 1, um sicherzustellen,
//          dass die erzeugte Zahl im gewünschten Bereich liegt.
//          Das + lowestValue stellt sicher, dass die erzeugte Zahl mindestens lowestValue ist.

            arrayList[i] = random.nextInt(highestValue - lowestValue + 1) + lowestValue;
        }

        return arrayList;
    }

    public static String arrayListToString (int[] array) {
        String prefix = "int[] array = {";
        String suffix = "};";
        String separation = ", ";
        for (int i = 0; i < array.length; i++) {
            prefix = prefix + array[i];
            if (i < array.length-1) {
                prefix = prefix + separation;
            }
        }
        prefix = prefix + suffix;
        return prefix;
    }
}