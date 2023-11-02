
/**
 * User: Timo
 * Date: 02.11.2023
 * Time: 23:57
 */
public class CountingSort {
    static int runtime = 0;
    public static void main(String[] args) {
        int[] unsortedArrayList = { 15, 6, 2, 1, 8, 11, 3, 2 };
        runtime = 0;

        int[] sortedArrayList = sort(unsortedArrayList);

        System.out.println("done...\n> " + arrayListToString(sortedArrayList) + "\nruntime: (" + runtime + "/" + unsortedArrayList.length + "; efficiency: " + (double) runtime/ unsortedArrayList.length +")");
    }

    public static int[] sort (int[] arrayList) {
        int maximum = arrayList[0];
        for (int i = 1; i < arrayList.length; i++) {
            if (arrayList[i] > maximum)
                maximum = arrayList[i];
            runtime++;
        }
        int[] tempArrayList = new int[maximum+1];
        for (int i = 0; i < arrayList.length; i++) {
            tempArrayList[arrayList[i]]++;
            runtime++;
        }
        int position = 0;
        for (int i = 0; i <= maximum; i++) {
            for (int j = 0; j < tempArrayList[i]; j++) {
                arrayList[position] = i;
                position++;
                runtime++;
            }
            runtime++;
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