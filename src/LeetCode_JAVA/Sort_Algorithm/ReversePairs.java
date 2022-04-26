package LeetCode_JAVA.Sort_Algorithm;

public class ReversePairs {
    /*
    https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
     */

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right){
        if (left == right) return 0;
        int mid = left + ((right - left) >> 1);
        return mergeSort(nums, left, mid) +  mergeSort(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    public int merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        for (int i = left; i <= right; ++i) temp[i - left] = nums[i];
        int pairs = 0, i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right){
            if (temp[i - left] > temp[j - left]){
                pairs += mid - i + 1;
                nums[k++] = temp[j++ - left];
            } else nums[k++] = temp[i++ - left];
        }
        while (i <= mid) nums[k++] = temp[i++ - left];
        while (j <= right) nums[k++] = temp[j++ - left];
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{7, 5, 6, 4}));
    }

}
