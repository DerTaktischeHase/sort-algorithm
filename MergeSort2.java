import java.util.Arrays;

public class MergeSort2 {
    public static void main (String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        split(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void split (int[] array) {
        if (array.length <= 1) {
            return;
        }

        int max = array.length;
        int mid = array.length/2;

        int[] left = new int[mid];
        int[] right = new int[max - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < max; i++) {
            right[i - mid] = array[i];
        }

        split(left); // rekursiv
        split(right); // rekursiv
        merge(array, left, right);
    }

    public static void merge (int[] array, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, arrayIndex =0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[arrayIndex++] = left[leftIndex++];
            } else {
                array[arrayIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            array[arrayIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            array[arrayIndex++] = right[rightIndex++];
        }

    }
}
