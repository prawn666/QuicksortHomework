import java.util.Arrays;

public class Quicksort {

    public static void main(String[] args) {
        Integer[] array = {4, 2, 0, 3, 5, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int partitioning = partitioning(array, low, high);
        sort(array, low, partitioning - 1);
        sort(array, partitioning + 1, high);
    }

    private static int partitioning(Comparable[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (array[++i].compareTo(array[low]) < 0) {
                if (i == high) {
                    break;
                }
            }

            while (array[--j].compareTo(array[low]) > 0) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, low, j);
        return j;
    }


    public static void swap(Comparable[] array, int i1, int i2) {
        Comparable tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
