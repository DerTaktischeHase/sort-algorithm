import java.util.Random;

public class MergeSort7 {
    public static int runtime = 0;
    public static void main (String[] args) {
        int[] randomArray = createRandomArray(10, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println(arrayListToString(randomArray, "randomArray"));

        split(randomArray);

        System.out.println("\ndone...\n> " + arrayListToString(randomArray, "randomArray") + "\nruntime: (" + runtime + "/" + randomArray.length +
                "; efficiency: " + (double) runtime/ randomArray.length +")");
    }

    public static int[] createRandomArray (int range, int min, int max) {
        int[] randomArray= new int[range];
        Random random = new Random();
        for (int i = 0; i < range; i++) {
            randomArray[i] = random.nextInt(min, max);
        }
        return randomArray;
    }

    public static void split (int[] array) {
        if (array.length <= 1) return;

        int mid = array.length/2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
            runtime++;
        }

        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
            runtime++;
        }

        split(left);
        split(right);

        merge(array, left, right);
    }


    public static void merge (int[] array, int[] left, int[] right) {
        int arrayIndex = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[arrayIndex++] = left[leftIndex++];
            } else {
                array[arrayIndex++] = right[rightIndex++];
            }
            runtime++;
        }

        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex < left.length) {
                array[arrayIndex++] = left[leftIndex++];
            } else {
                array[arrayIndex++] = right[rightIndex++];
            }
            runtime++;
        }

    }


    public static String arrayListToString (int[] array) {
        StringBuilder prefix = new StringBuilder("int[] array = {");
        String suffix = "};";
        String separation = ", ";
        for (int i = 0; i < array.length; i++) {
            prefix.append(array[i]);
            if (i < array.length-1) {
                prefix.append(separation);
            }
        }
        prefix.append(suffix);
        return prefix.toString();
    }

    public static String arrayListToString (int[] array, String name) {
        StringBuilder prefix = new StringBuilder("int[] " + name + " = {");
        String suffix = "};";
        String separation = ", ";
        for (int i = 0; i < array.length; i++) {
            prefix.append(array[i]);
            if (i < array.length-1) {
                prefix.append(separation);
            }
        }
        prefix.append(suffix);
        return prefix.toString();
    }
}
