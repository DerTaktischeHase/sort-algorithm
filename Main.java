/**
 * User: Timo
 * Date: 25.11.2023
 * Time: 17:19
 */
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int RUNTIME = 0;
    public static int MERGESORT_RUNTIME, BUBBLESORT_RUNTIME, COUNTINGSORT_RUNTIME, SELECTIONSORT_RUNTIME;
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min, max;


        System.out.println("Gib mir die untere Listenlänge an (z.B. 500) oder drücke einfach Enter:");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            min = 500;
            
        } else {
            try {
                min = Integer.parseInt(input);
                if (min < 1) {
                    min = 1;
                    System.out.println("Mindestens 1, sorry!");
                }
            } catch (NumberFormatException e) {
                min = 500; // Standardwert, wenn keine gültige Zahl eingegeben wurde
            }
        }
        log("Die untere Grenze wurde auf " + min + " gesetzt");

        System.out.println("Gib mir die obere Listenlänge an (z.B. 510) oder drücke einfach Enter:");
        input = scanner.nextLine();

        if (input.isEmpty()) {
            max = 510;
        } else {
            try {
                max = Integer.parseInt(input);
                if (max < 1) {
                    max = 1;
                    System.out.println("Mindestens 1, sorry!");
                }
            } catch (NumberFormatException e) {
                max = 510; // Standardwert, wenn keine gültige Zahl eingegeben wurde
            }
        }
        log("Die untere Grenze wurde auf " + max + " gesetzt");
        
        log("\nDies sind alle 4 Sortieralgorithmen und ihre Laufzeit (L = Laenge der Liste)\n - mit zufälligen Werten von 0 bis 100\n - und mit einer Listen-Laenge von " + min + " bis " + max);

        RUNTIME = 0;
        log("\n - MergeSort");
        for (int i = min; i <= max; i++) {
            int[] randomArrayMerge = createRandomArray(i, 0, 100);
            MergeSort(randomArrayMerge);
            logger(randomArrayMerge);
        }
        MERGESORT_RUNTIME = RUNTIME;
        RUNTIME = 0;

        log("\n - CountingSort");

        for (int i = min; i <= max; i++) {
            int[] randomArrayCounting = createRandomArray(i, 0, 100);
            CountingSort(randomArrayCounting);
            logger(randomArrayCounting);
        }
        COUNTINGSORT_RUNTIME = RUNTIME;
        RUNTIME = 0;

        log("\n - BubbleSort");
        
        for (int i = min; i <= max; i++) {
            int[] randomArrayBubble = createRandomArray(i, 0, 100);
            BubbleSort(randomArrayBubble);
            logger(randomArrayBubble);
        }
        BUBBLESORT_RUNTIME = RUNTIME;
        RUNTIME = 0;

        log("\n - SelectionSort");

        for (int i = min; i <= max; i++) {
            int[] randomArraySelection = createRandomArray(i, 0, 100);
            SelectionSort(randomArraySelection);
            logger(randomArraySelection);
        }
        SELECTIONSORT_RUNTIME = RUNTIME;
        RUNTIME = 0;

        log("\nfinished with Runtime >> MergeSort: " + MERGESORT_RUNTIME + ", CountingSort: " + COUNTINGSORT_RUNTIME + ", BubbleSort: " + BUBBLESORT_RUNTIME + ", SelectionSort: " + SELECTIONSORT_RUNTIME + " << Arraylength is " + max);
    }

    public static void logger (int[] list) {
        System.out.println("L: (" + list.length + ") RUNTIME -> " + RUNTIME + " | efficiency -> " + Math.round((double) RUNTIME/ list.length)); // L -> Length/Laenge
    }

    public static void log (String log) {
        System.out.println(log);
    }

    public static int[] createRandomArray (int range, int min, int max) {
        int[] randomArray= new int[range];
        Random random = new Random();
        for (int i = 0; i < range; i++) {
            randomArray[i] = random.nextInt(max);
            //System.out.println("random: " + randomArray[i]);
        }
        //log(arrayListToString(randomArray));
        return randomArray;
    }

    // SelectionSort

    public static void SelectionSort (int[] arrayList) {
        int b = 0;
        while (b < arrayList.length) {
            RUNTIME++;
            int lowestElementIndex = b;
            for(int i= b; i < arrayList.length-1; i++) {
                RUNTIME++;
                if (arrayList[i+1] < arrayList[lowestElementIndex]) {
                    lowestElementIndex = i+1;
                }
            }
            switchElements(lowestElementIndex, b, arrayList);
            b++;
        }
    }



// BubbleSort

    public static void BubbleSort (int[] arrayList) {
        while (!isSorted(arrayList)) {
            RUNTIME++;
            for (int i = 0; i < arrayList.length-1; i++) {
                RUNTIME++;
                if (arrayList[i] > arrayList[i+1]) {
                    switchElements(i, i+1, arrayList);
                }
            }
        }
    }

    public static void switchElements (int index1, int index2, int[] arrayList) {
        int tempValue = arrayList[index1];
        arrayList[index1] = arrayList[index2];
        arrayList[index2] = tempValue;
        RUNTIME++;
    }

    public static boolean isSorted (int[] arrayList) {
        boolean isSorted = true;
        for (int i = 0; i < arrayList.length-1; i++) {
            RUNTIME++;
            if (arrayList[i] > arrayList[i+1]) {
                isSorted = false;
                return isSorted;
            }
        }
        return isSorted;
    }



// CountingSort

public static int[] CountingSort(int[] arrayList) {
    int maximum = arrayList[0];
    for (int i = 1; i < arrayList.length; i++) {
        if (arrayList[i] > maximum)
            maximum = arrayList[i]; // Aktualisiere das Maximum, wenn ein größeres Element gefunden wird
        RUNTIME++;
    }

    int[] tempArrayList = new int[maximum + 1];

    for (int i = 0; i < arrayList.length; i++) {
        tempArrayList[arrayList[i]]++; // Zähle die Vorkommnisse jedes Elements
        RUNTIME++;
    }

    int position = 0;

    for (int i = 0; i <= maximum; i++) {
        for (int j = 0; j < tempArrayList[i]; j++) {
            arrayList[position] = i; // Befülle das sortierte Array mit dem aktuellen Element
            position++;
            RUNTIME++;
        }
        RUNTIME++;
    }

    return arrayList;
}



// Mergesort

    public static void MergeSort (int[] array) {
        if (array.length <= 1) return;

        int mid = array.length/2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
            RUNTIME++;
        }

        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
            RUNTIME++;
        }

        MergeSort(left);
        MergeSort(right);

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
            RUNTIME++;
        }

        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex < left.length) {
                array[arrayIndex++] = left[leftIndex++];
            } else {
                array[arrayIndex++] = right[rightIndex++];
            }
            RUNTIME++;
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

