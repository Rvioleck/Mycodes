package LeetCode_JAVA;

public class SumOddLengthSubarrays {

    /*
    * https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/
    * */
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; ++i){
            prefix[i] = prefix[i - 1] + arr[i];
        }
        int res = 0;
        for (int i = 0; i < arr.length; ++i){
            for (int j = i; j >= 0; j -= 2){
                res += prefix[i] - prefix[j] + arr[j];
            }
        }
        return res;
    }
}
