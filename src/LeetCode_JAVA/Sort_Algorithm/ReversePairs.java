package LeetCode_JAVA.Sort_Algorithm;

public class ReversePairs {

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return 0;
        }
        int[] temp = new int[len];
        return reversePairs(nums, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = left - (left - right) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        int crossPairs = mergePairs(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergePairs(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid){
                nums[k] = temp[j++];
            } else if (j > right){
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]){
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += mid - i + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{7, 5, 6, 4}));
    }

}
