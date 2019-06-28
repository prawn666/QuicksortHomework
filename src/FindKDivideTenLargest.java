import java.util.Arrays;

public class FindKDivideTenLargest {

    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 1, 4, 5, 5, 4, 1, 1};
        partition(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void findKLargest(Comparable[] array, int k) {

    }

    private static void partition(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int lt = low;
        int gt = high;
        int i = low;
        Comparable item = array[low];

        while (i <= gt) {
            if (array[i].compareTo(item) > 0) {
                Quicksort.swap(array, i, gt--);
            } else if (array[i].compareTo(item) < 0) {
                Quicksort.swap(array, i++, lt++);
            } else {
                i++;
            }

        }
        partition(array, low, lt - 1);
        partition(array, gt + 1, high);
    }
}
