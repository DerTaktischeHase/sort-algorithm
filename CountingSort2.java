import java.util.Random;

/**
 * User: Timo
 * Date: 02.11.2023
 * Time: 23:57
 */
public class CountingSort2 {
    static int runtime = 0;
    public static void main(String[] args) {
        // Integer.MIN_VALUE = -2147483648 = -2^(31)
        // Integer.MAX_VALUE = +2147483647 = +2^(31)-1
        int[] unsortedArrayList = randomArrayList(1, 1000, 5000); // the limit must be positive (example: 1, 500, 10)
        runtime = 0;

        int[] sortedArrayList = sort(unsortedArrayList);

        System.out.println("done...\n> " + arrayListToString(sortedArrayList) + "\nruntime: (" + runtime + "/" + unsortedArrayList.length + "; efficiency: " + (double) runtime/ unsortedArrayList.length +")");
    }

    public static int[] sort(int[] arrayList) {
        int maximum = arrayList[0];
        for (int i = 1; i < arrayList.length; i++) {
            if (arrayList[i] > maximum)
                maximum = arrayList[i]; // Aktualisiere das Maximum, wenn ein größeres Element gefunden wird
            runtime++;
        }

        int[] tempArrayList = new int[maximum + 1];

        for (int i = 0; i < arrayList.length; i++) {
            tempArrayList[arrayList[i]]++; // Zähle die Vorkommnisse jedes Elements
            runtime++;
        }

        int position = 0;

        for (int i = 0; i <= maximum; i++) {
            for (int j = 0; j < tempArrayList[i]; j++) {
                arrayList[position] = i; // Befülle das sortierte Array mit dem aktuellen Element
                position++;
                runtime++;
            }
            runtime++;
        }

        return arrayList;
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