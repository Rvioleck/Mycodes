package LeetCode_JAVA.TwoPointer.SlideWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new FindContinuousSequence().findContinuousSequence(15)));
    }

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2;
        int windowSum = 3;
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2){
            if (windowSum == target){    // 得到目标值，计算并加入结果集，前指针后移
                int[] arr = new int[j - i + 1];
                for (int k = i; k <= j; ++k){
                    arr[k - i] = k;
                }
                res.add(arr);
                windowSum -= i++;
            } else if (windowSum < target){ // 小于目标值，后指针后移
                windowSum += ++j;
            } else {  // 大于目标值，前指针后移
                windowSum -= i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
