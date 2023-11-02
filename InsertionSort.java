/**
 * User: Timo
 * Date: 02.11.2023
 * Time: 22:23
 */
public class InsertionSort {
    public static void main(String[] args) {

        int[] arrayList = { 15, 6, 2, 1, 8, 11, 3, 2 };

        sort(arrayList);

        System.out.println("done...\n> " + arrayListToString(arrayList));
    }

    public static void sort (int[] arrayList) {
        for (int i = 1; i < arrayList.length; i++) {
            System.out.println(arrayListToString(arrayList) + " (element: " + arrayList[i] + ")"); // TODO: debug
            int element = arrayList[i];
            int k = i; // current position of our element
            while (k > 0 && arrayList[k-1] > element) {
                System.out.println("  - (k: " + k + ")"); // TODO: debug
                arrayList[k] = arrayList[k-1];
                arrayList[k-1] = element;
                k--;
            }
        }
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