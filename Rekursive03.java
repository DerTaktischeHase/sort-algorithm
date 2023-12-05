public class Rekursive03 {

    public static int addition (int a, int b) {
        if (b != 0) {
            if (b > 0) {
                b--;
                a++;
            } else {
                b++;
                a--;
            }
            return addition(a, b);
        } else {
            return a;
        }
    }

    public static int subtraction (int a, int b)  {
        if (b != 0) {
            if (b > 0) {
                b--;
                a--;
            } else {
                b++;
                a++;
            }
            return subtraction(a, b);
        } else {
            return a;
        }
    }

    public static double division (int a, int b) {
        return a/b;
    }

    public static void main (String[] args) {
        test(5, 3, 5);
    }

    public static void test (int a, int b, int intervalle) {
        for(int i = 1; i <= intervalle; i++) {
            a = a +i;
            b = b +i;
        System.out.println("Test #" + i);
        System.out.println(a + " + " + b + " = " + addition(a, b));
        System.out.println(a + " - " + b + " = " + subtraction(a, b));
        System.out.println(a + " / " + b + " = " + division(intervalle, b));
        }
    }
}