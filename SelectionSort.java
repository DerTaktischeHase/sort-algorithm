/**
 * User: Timo
 * Date: 05.11.2023
 * Time: 11:47
 */
public class SelectionSort {
    static int runtime;
    public static void main(String[] args) {
        int[] arrayList = { 15, 6, 2, 1, 8, 11, 3, 2 };
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
