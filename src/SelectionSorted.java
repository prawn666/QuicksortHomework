public class SelectionSorted {

    public static void main(String[] args) {
        int[] arr1 = {0, 4, 7, 12, 19};
        int[] arr2 = {1, 3, 10, 15, 16, 18};
        System.out.println(findKLargest(arr1, arr2, 8));
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

        if (low1 == high1) {
            return array2[high2 - k];
        }
        if (low2 == high2) {
            return array1[high1 - k];
        }

        float mid1 = (float) (low1 + (high1 - low1) / 2.0);
        float mid2 = (float) (low2 + (high2 - low2) / 2.0);
        int med1 = median(array1, low1, high1);
        int med2 = median(array2, low2, high2);
        boolean evenMed1 = (high1 - low1) % 2 == 0;
        boolean evenMed2 = (high2 - low2) % 2 == 0;
        int right = ((high1 - low1)) + ((high2 - low2));

        if (right == k) {
            return (array1[low1] < array2[low2]) ? array1[low1] : array2[low2];
        }

        if (right == k + 1) {
//            return (array1[low1] > array2[low2]) ? array1[low1] : array2[low2];
        }

        int newHalf1 = (high1 - (int) (mid1 + 0.5)) + high2 - low2;
        int newHalf2 = (high2 - (int) (mid2 + 0.5)) + high1 - low1;
        int rightCount1 = (int) (high1 - mid1 + 0.5);
        int rightCount2 = (int) (high2 - mid2 + 0.5);


//        if (evenMed1 && (high1 - low1) / 2 > mid1) mid1++;
//        if (evenMed2 && (high2 - low2) / 2 > mid2) mid2++;
        int newMid1 = (int) (mid1 % 1 > 0 ? mid1 - 0.5 : mid1);
        int newMid2 = (int) (mid2 % 1 > 0 ? mid2 - 0.5 : mid2);

        if (med1 == med2) {
            if (high1 - low1 == 1) {
                if (k > rightCount2 + rightCount1) {
                    return findKLargest(array1, array2, low1, high1, low2, newMid2, k - rightCount2, half);
                } else {
                    return findKLargest(array1, array2, low1, high1, (int) (mid2 + 0.5), high2, k, newHalf2);
                }
            } else if (high2 - low2 == 1) {
                if (k > rightCount1 + rightCount2) {
                    return findKLargest(array1, array2, low1, newMid1, low2, high2, k - rightCount1, half);
                } else {
                    return findKLargest(array1, array2, (int) (mid1 + 0.5), high1, low2, high2, k, newHalf1);
                }
            }
        }

        if (med1 > med2) {
            if (k > rightCount1 + rightCount2 && high1 - low1 != 1) {
                return findKLargest(array1, array2, low1, newMid1, low2, high2, k - rightCount1, half);
            } else if ((high1 - low1) + (high2 - low2) - (mid2 + 0.5 - low2) < k) {
                return findKLargest(array1, array2, low1, high1, newMid2, high2, k, newHalf2);
            } else {
                return findKLargest(array1, array2, low1, high1, (int) (mid2 + 0.5), high2, k, newHalf2);
            }
        } else {
            if (k > rightCount2 + rightCount1 && high2 - low2 != 1) {
                return findKLargest(array1, array2, low1, high1, low2, newMid2, k - rightCount2, half);
            } else if ((high1 - low1) + (high2 - low2) - (mid1 + 0.5 - low1) < k) {
//                return findKLargest(array1, array2, low1, (int) (mid1 + 0.5), low2, high2, k - rightCount1, newHalf1);
                return findKLargest(array1, array2, newMid1, high1, low2, high2, k, newHalf1);
            } else {
                return findKLargest(array1, array2, (int) (mid1 + 0.5), high1, low2, high2, k, newHalf1);
            }
        }
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