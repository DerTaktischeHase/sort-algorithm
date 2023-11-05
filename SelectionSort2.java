import java.util.Random;

/**
 * User: Timo
 * Date: 05.11.2023
 * Time: 20:00
 */
public class SelectionSort2 {
    static int runtime;
    public static void main(String[] args) {
        // Integer.MIN_VALUE = -2147483648 = -2^(31)
        // Integer.MAX_VALUE = +2147483647 = +2^(31)-1
        int[] arrayList = randomArrayList(1, 1000, 5000); // the limit must be positive (example: 1, 500, 10)
        System.out.println("original ArrayList: \n" + arrayListToString(arrayList));
        runtime = 0;

        sort(arrayList);

        System.out.println("done...\n> " + arrayListToString(arrayList) + "\nruntime: (" + runtime + "/" + arrayList.length + 
        "; efficiency: " + (double) runtime/ arrayList.length +")");
    }

    public static void sort (int[] arrayList) {
        int b = 0;
        while (b < arrayList.length) { // TODO: correct
            int lowestElementIndex = b;
            for(int i= b; i < arrayList.length-1; i++) {
                if (arrayList[i+1] < arrayList[lowestElementIndex]) {
                    lowestElementIndex = i+1;
                }
                runtime++;
            }
            switchElements(lowestElementIndex, b, arrayList); // TODO: correct
            b++;
        }
    }

    public static void switchElements (int index1, int index2, int[] arrayList) {
        int tempValue = arrayList[index1];
        arrayList[index1] = arrayList[index2];
        arrayList[index2] = tempValue;
        runtime++;
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
