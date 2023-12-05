public class MergeSort8 {
  public static void sort (int[] list) {
    split(list);
  }

  public static void split (int[] list) {
    if (list.length == 1) return list;

    // Teilen und Beherrschen
    // #1 Teilen

    int[] left = new int[list.length/2];
    int[] right = new int[list.length - (list.length/2)];

    for (int i = 0; i < list.length/2; i++) {
      left[i] = list[i];
    }

    for (int i = (list.length/2); i < list.length; i++) {
      right[i - (list.length/2)] = list[i];
    }

    split(left);
    split(right);

    merge(list, left, right);
  }

  public static void merge (int[] list, int[] left, int[] right) {
    int regularIndex = 0, leftIndex = 0, rightIndex = 0;

    while (leftIndex < left.length && rightIndex < right.length) {
      if (left[leftIndex] > right[rightIndex]) {
        list[regularIndex] = right[rightIndex];
        regularIndex++, rightIndex++;
      } else if (right[rightIndex] > left[leftIndex]){
        list[regularIndex] = left[leftIndex];
        regularIndex++, leftIndex++;
      }
    }

    while (leftIndex < left.length) {
      list[regularIndex] = left[leftIndex];
      regularIndex;
      leftIndex++; 
    }

    while (rightIndex < right.length) {
      list[regularIndex] = right[rightIndex];
      regularIndex++;
      rightIndex++; 
    }

  }
  public static void main (String[] args) {
    int[] list = new int[]{ 4, 6, 2, 4, 8};
    sort(list);
    System.out.println();
  }
}
