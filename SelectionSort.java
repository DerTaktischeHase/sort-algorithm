import java.util.Arrays;

public class SelectionSort {
    public static void sort (int[] list) {
        for(int start = 0; start < list.length; start++) {
            int min = start;
            for(int current = start+1; current < list.length; current++) {
                if (list[current] < list[min]) {
                    min = current;
                }
            }
            switchElement(list, min, start);
        }
    }

    public static void switchElement (int[] list, int i, int k) {
        int temp = list[i];
        list[i] = list[k];
        list[k] = temp;

    }
    public static void main (String[] args) {
        int[] list = new int[]{0, 4, 5, 2, 5};
        System.out.println(Arrays.toString(list));
        sort(list);
        System.out.println(Arrays.toString(list));
    }
}
