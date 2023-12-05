public class CountingSort4 {
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

    merge();
  }

  public static void merge (int[] list, int[] left, int[] right) {

  }
  public static void main (String[] args) {
    
  }
}
