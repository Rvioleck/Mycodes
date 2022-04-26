package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;

public class HeapSort2 {

    public static void main(String[] args) {
        int[] nums = {1,5,2,3,4,7,6,1,2,5};
        System.out.println("Before: " + Arrays.toString(nums));
        new HeapSort2().heapSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    public void swap(int[] nums, int i, int j){
        if (i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public void heapInsert(int[] nums, int index){
        while (nums[index] > nums[((index - 1) / 2)]){
            swap(nums, index, ((index - 1) >> 1));
            index = (index - 1) >> 1;
        }
    }

    public void heapify(int[] nums, int index, int len){
        // 以index为结点的子树进行大根堆化
        int left = index * 2 + 1;
        while (left < len){
            int largest = left + 1 < len && nums[left + 1] > nums[left]
                    ? left + 1 : left;
            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index) break;
            swap(nums, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public void heapSort(int[] nums){
        if (nums == null || nums.length < 2){
            return;
        }
        for (int i = 0; i < nums.length; ++i){
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while (heapSize > 0){
            heapify(nums, 0, heapSize);  // O(logN)
            swap(nums, 0, --heapSize);  // O(1)
        }
    }
}
