import java.util.Random;

public class MergeSort7 {
    public static void main (String[] args) {
        int[] array = { 4, 2, 7, 5 };
        split(array);
        System.out.println(arrayListToString(array));
    }

    public static int randomNumber (int range) {
        Random random = new Random();
        int rn = random.nextInt(range);
        return 0;
    }

    public static void split (int[] array) {
        if (array.length <= 1) return;

        int mid = array.length/2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
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
        }



        
        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex < left.length) {
                array[arrayIndex++] = left[leftIndex++];
            } else if (rightIndex < right.length) {
                array[arrayIndex++] = right[rightIndex++];
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
