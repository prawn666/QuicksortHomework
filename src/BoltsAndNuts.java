import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class BoltsAndNuts {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Integer[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            Integer[] array2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            StdRandom.shuffle(array1);
            StdRandom.shuffle(array2);
            sort(array1, array2);
            for (int j = 0; j < array1.length; j++) {
                assert array1[j].compareTo(array2[j]) == 0;
            }
        }
    }


    public static void sort(Comparable[] array1, Comparable[] array2) {
        sort(array1, array2, 0, array1.length - 1);
    }

    private static void sort(Comparable[] array1, Comparable[] array2, int low, int high) {
        if (low >= high) {
            return;
        }
        int partitioning = partitioning(array1, array2, low, high);
        sort(array1, array2, low, partitioning - 1);
        sort(array1, array2, partitioning + 1, high);
    }

    private static int partitioning(Comparable[] array1, Comparable[] array2, int low, int high) {
        int i = low;
        int j = high + 1;

        while (true) {

            while (array1[low].compareTo(array2[++i]) > 0) {
                if (i == high) {
                    break;
                }
            }

            while (array1[low].compareTo(array2[--j]) < 0) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            Quicksort.swap(array1, i, j);
        }
        Quicksort.swap(array1, low, j);

        i = low;
        j = high + 1;
        while (true) {

            while (array2[low].compareTo(array1[++i]) > 0) {
                if (i == high) {
                    break;
                }
            }

            while (array2[low].compareTo(array1[--j]) < 0) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            Quicksort.swap(array2, i, j);
        }
        Quicksort.swap(array2, low, j);
        return j;
    }
}
