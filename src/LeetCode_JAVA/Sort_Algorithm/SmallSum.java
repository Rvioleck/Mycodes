package LeetCode_JAVA.Sort_Algorithm;

import org.junit.Test;

public class SmallSum {
    /*
        小和问题，其为归并排序的变体

     */

    public static int bf(int[] nums){
        // 暴力法实现小和问题
        int res = 0;
        for (int i = 0;  i < nums.length; ++i){
            for (int j = i; j < nums.length; ++j){
                if (nums[j] > nums[i]){
                    res += nums[i];
                }
            }
        }
        return res;
    }

    public static int smallSum(int[] nums){
        // 归并排序实现小和问题
        if (nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int left, int right){
        if (left == right){
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int leftSum = mergeSort(nums, left, mid);
        int rightSum = mergeSort(nums, mid + 1, right);
        int crossSum = merge(nums, left, mid, right);
        return leftSum + rightSum + crossSum;
    }

    public static int merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[nums.length];
        for (int i = left; i <= right; ++i){
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1, k = left, sum = 0;
        while (i <= mid && j <= right){
            if (temp[i] < temp[j]){
                nums[k++] = temp[i];
                sum += temp[i++] * (right - j + 1);
            }
            else nums[k++] = temp[j++];
        }
        while (i <= mid) nums[k++] = temp[i++];
        while (j <= right) nums[k++] = temp[j++];
        return sum;
    }

    // 返回一个数组arr，arr长度[0,maxLen-1],arr中的每个值[0,maxValue-1]
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // arr1和arr2一定等长
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    @Test
    public void test1(){
        // 对数器，对小和问题的O(nlogn)算法验证
        int maxLen = 15;
        int maxValue = 1000;
        int testTime = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] tmp = copyArray(arr1);
            if (bf(tmp) != smallSum(arr1)) {
                System.out.println("小和问题！");
                break;
            }
        }
        System.out.println("成功！");
    }


}
