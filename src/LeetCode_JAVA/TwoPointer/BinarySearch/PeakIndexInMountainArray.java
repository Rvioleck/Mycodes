package LeetCode_JAVA.TwoPointer.BinarySearch;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid + 1] > arr[mid]) {
                left = mid + 1;
            } else if (arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 10, 5, 2};
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(arr));
    }

}
