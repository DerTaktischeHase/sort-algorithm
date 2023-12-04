public class Rekursion02 {

    public static int subtract (int a, int b) {
        if (b < 0) { // -a
            b++;
            a++;
        } else if (b > 0){
            b--;
            a--;
        }

        if (b == 0) {
            return a;
        } else {
            return subtract(a, b);
        }
    }

    public static void main (String[] args) {
        int a = 500;
        int b = 99;

        System.out.println(a + " - " + b + " = " + subtract(a, b));
    }
}
