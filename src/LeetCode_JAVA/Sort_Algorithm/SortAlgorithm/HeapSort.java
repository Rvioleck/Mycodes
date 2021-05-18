package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println("Before: " + Arrays.toString(nums));
        new HeapSort().heapSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    /**
     * @param nums 初始无序序列
     * @param len 序列长度(堆大小)
     */
    public void buildMaxHeap(int[] nums, int len){
        for (int i = len / 2; i >= 0; --i){
            // 从下标为[len / 2] ~ 0进行反复调整堆，以此建立大根堆
            headAdjust(nums, i, len);
        }
    }
    /**
     * @param nums 待调整堆
     * @param k 所调整结点下标
     * @param len 堆大小
     * 对下标为k的元素为根的子树进行循环堆调整
     */
    public void headAdjust(int[] nums, int k, int len){
        int temp = nums[k];  // 保存根元素副本
        for (int i = 2 * k; i < len; i *= 2){
            i++; // 子结点为2k+1和2k+2，因此此时i=2k+1指向左子结点
            if (i + 1 < len && nums[i] < nums[i + 1]){
                // 如果右子结点存在且右子结点更大，则指向右子结点
                i++;
            }
            // 如果原根结点大于较大的右子结点，无需调整
            if (temp > nums[i]) break;
            else {
                // 否则将较大结点替换原根结点，并更新k值(将原根结点向下换)
                nums[k] = nums[i];
                k = i;
            }
        }
        nums[k] = temp;    // 将初始根结点放入合适位置
    }

    public void heapSort(int[] nums){
        // 建立初始大根堆
        buildMaxHeap(nums, nums.length);
        for (int i = nums.length - 1; i >= 1; --i){
            // 把最大值交换到序列尾(根值交换到下标i->即为有效长度的堆尾)
            nums[0] ^= nums[i];
            nums[i] ^= nums[0];
            nums[0] ^= nums[i];
            // 上述交换之后，根值不再最大，重新调整堆为大根堆
            // (此时有效长度就要需要排除已经交换到队尾的最大值)
            // 因为最大值元素在逻辑上，移除了堆输出
            // 但在物理存储上，仍然在该序列的序列后方(顺序排序大值在后)
            headAdjust(nums, 0, i - 1);
        }
    }

}
