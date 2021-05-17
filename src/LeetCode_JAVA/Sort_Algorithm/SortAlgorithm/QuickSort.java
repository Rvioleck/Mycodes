package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 5, 0, 9, 8, 1, 2};
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 快速排序quickSort
     * @param nums 待排序数组
     * @param left 待排序序列的左下标
     * @param right 待排序序列的右下标
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            // 由划分函数得到中间数pivot的下标
            int pivotIdx = partition(nums, left, right);
            // 递归的分别对(left, pivotIdx)和(pivotIdx + 1, right)进行快速排序
            quickSort(nums, left, pivotIdx);
            quickSort(nums, pivotIdx + 1, right);
        }
    }

    /**
     * 划分数组函数partition()
     * @param nums 待排序数组
     * @param left 待划分序列的左下标
     * @param right 待划分序列的右下标
     * @return 划分分界点的下标(pivot枢轴的下标值)
     */
    private int partition(int[] nums, int left, int right) {
        // 取第一个元素为枢轴pivot值(第一个元素为nums[left]而非nums[0]，因为分治的过程中上下界在动态变化)
        int pivotVal = nums[left];
        while (left < right) {  // 循环跳出条件
            while (left < right && nums[right] >= pivotVal) {
                right--;              // 从右侧开始找到比pivot小的值的下标
            }
            nums[left] = nums[right]; // 将比pivot小的元素移动到左端
            while (left < right && nums[left] <= pivotVal) {
                left++;               // 从左侧开始找到比pivot大的值的下标
            }
            nums[right] = nums[left]; // 将比pivot大的元素移动到右端
        }
        nums[left] = pivotVal;   // 将原来位于第一位的pivot放置其正确位置(左边全小，右边全大)
        return left;   // 返回pivot的下标值，用于后续子表的递归求解
    }

    private int partition2(int[] nums, int left, int right) {
        // 随机寻找pivot元素(并将其交换到第一个)
        int i = new Random().nextInt(right - left + 1) + left;
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
        // 后续与原方法相同
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    private int partition3(int[] nums, int left, int right) {
        // 选取头尾和中间的元素的中位数作为中间元素
        int a = nums[left], b = nums[(left + right)/ 2], c = nums[right];
        if (c > b && c < a || c > a && c < b){
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
        }
        if (b > a && b < c || b > c && b < a){
            nums[(left + right)/ 2] ^= nums[left];
            nums[left] ^= nums[(left + right)/ 2];
            nums[(left + right)/ 2] ^= nums[left];
        }
        // 后续与原方法相同
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

}
