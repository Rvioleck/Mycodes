package LeetCode_JAVA;

public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums){  // 词频统计
            freq[num]++;
        }
        int preVal = freq[0]; // preVal记录前一个值
        freq[0] = 0;
        for (int i = 1; i < 101; ++i){ // 将freq数组改为前缀和数组（不包括当前值）
            int num = freq[i];
            freq[i] = preVal + freq[i - 1];
            preVal = num;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i){
            res[i] = freq[nums[i]];
        }
        return res;
    }
}
