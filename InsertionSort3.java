import java.util.Random;

/**
 * User: Timo
 * Date: 06.11.2023
 * Time: 22:32
 */
public class InsertionSort3 {
    public static void main(String[] args) {
        // Integer.MIN_VALUE = -2147483648 = -2^(31)
        // Integer.MAX_VALUE = +2147483647 = +2^(31)-1
        int[] arrayList = randomArrayList(1, 100, 1000); // the limit must be positive (example: 1, 500, 10)
        System.out.println(arrayListToString(arrayList));

        int runtime = sort (arrayList);

        System.out.println("\ndone...\n> " + arrayListToString(arrayList) + "\nruntime: (" + runtime + "/" + arrayList.length +
                "; efficiency: " + (double) runtime/arrayList.length +")");
    }

    public static int sort(int[] arrayList) {
        int runtime = 0; // Initialisiere die Laufzeit-Zählervariable

        for (int i = 1; i < arrayList.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayList[j] < arrayList[j-1]) {
                    switchElements(j, j-1, arrayList);
                    runtime++;
                }
                runtime++;
            }
        }

        return runtime;
    }


    public static int[] randomArrayList (int lowestValue, int highestValue, int length) {
        int[] arrayList = new int[length];
        Random random = new Random();

        // the limit must be positive
        if (lowestValue < 1) lowestValue = 1;
        if (highestValue < 1) highestValue = 1;
        if (highestValue < lowestValue) highestValue = lowestValue+1;

        for (int i = 0; i < length; i++) {

//          random.nextInt(n) erzeugt eine Zufallszahl zwischen 0 (inklusiv) und n (exklusiv).
//          In diesem Fall ist n gleich highestValue - lowestValue + 1, um sicherzustellen,
//          dass die erzeugte Zahl im gewünschten Bereich liegt.
//          Das + lowestValue stellt sicher, dass die erzeugte Zahl mindestens lowestValue ist.

            arrayList[i] = random.nextInt(highestValue - lowestValue + 1) + lowestValue;
        }

        return arrayList;
    }

    public static void switchElements (int index1, int index2, int[] arrayList) {
        int tempValue = arrayList[index1];
        arrayList[index1] = arrayList[index2];
        arrayList[index2] = tempValue;
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