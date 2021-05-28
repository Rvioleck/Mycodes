package LeetCode_JAVA.BitwiseOperation;

/**
 * https://leetcode-cn.com/problems/total-hamming-distance/
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 */
public class TotalHammingDistance {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 2, 6, 9, 0, 12};
        System.out.println(new TotalHammingDistance().totalHammingDistance(nums));
    }

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i <= 31; ++i){
            int oneNum = 0;
            for (int num : nums){
                if (((num >> i) & 1) == 1){
                    oneNum++;
                }
            }
            res += oneNum * (n - oneNum);
        }
        return res;
    }

}
