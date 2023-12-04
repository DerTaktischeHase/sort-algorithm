public class Rekursion01 {
    // 0 1 1 2 3 5 8
    // 0 1 2 3 4 5 6
    public static int Fibunatcci (int n, int i, int preview, int current) {
        int temp = current;
        current = preview + current;
        preview = temp;
        if (i < n) {
            return Fibunatcci(n, i+1, preview, current);
        } else {
            return current;
        }
    }

    public static void main (String[] args) {
        System.out.println("Fibunatcci: 6 -> " + Fibunatcci(7, 2, 0, 1));
    }
}
