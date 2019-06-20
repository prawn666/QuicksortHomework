public class SelectionSorted {

    public static void main(String[] args) {
        int[] arr1 = {0, 4, 7, 12, 19};
        int[] arr2 = {1, 3, 10, 15, 16, 18};
        System.out.println(findKLargest(arr1, arr2, 0));
    }

    public static int findKLargest(int[] array1, int[] array2, int k) {
        int low1 = 0;
        int high1 = array1.length;
        int low2 = 0;
        int high2 = array2.length;
        return findKLargest(array1, array2, low1, high1, low2, high2, k, 0);
    }

    private static int findKLargest(
            int[] array1, int[] array2, int low1, int high1, int low2, int high2, int k, int half) {

//        if (high1 == -1) {
//            return high2;
//        } else if (high2 == -1) {
//            return high1;
//        }

        int mid1 = (low1 + (high1 - low1)) / 2 + (low1 + (high1 - low1)) % 2;
        int mid2 = (low2 + (high2 - low2)) / 2 + (low2 + (high2 - low2)) % 2;
        int med1 = median(array1, low1, high1);
        int med2 = median(array2, low2, high2);
        int right = (array1.length - (high1 - low1)) + (array2.length - (high2 - low2));


        if (right == k + 1) {
            return (array1[low1] < array2[low2]) ? array1[low1] : array2[low2];
        }

        int newHalf = (high1 - mid1) + high2 - low2;
        if (med1 > med2) {
            if (k > newHalf) {
                // return findKLargest(array1, array2, low1, mid1, low2, high2, k, newHalf);
            } else {
                return findKLargest(array1, array2, low1, high1, mid2, high2, k, newHalf);
            }
        } else {
            if (k > newHalf) {
                //  return findKLargest(array1, array2, low1, high1, low2, mid2, k, newHalf);
            } else {
                return findKLargest(array1, array2, mid1, high1, low2, high2, k, newHalf);
            }
        }
        return -1;
    }

    private static int median(int[] arr, int low, int high) {
        if (high - low == 1) {
            return arr[low];
        }

        int mid = low + (high - low) / 2;

        if ((high - low) % 2 != 1) {
            return (arr[mid - 1] + arr[mid]) / 2;
        }
        return arr[mid];
    }

}