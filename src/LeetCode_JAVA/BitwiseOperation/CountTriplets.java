package LeetCode_JAVA.BitwiseOperation;

/**
 * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 *     a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 *     b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 */
public class CountTriplets {

    public static void main(String[] args) {
        System.out.println(new CountTriplets().countTriplets(new int[]{2,3,1,6,7}));
    }

    public int countTriplets(int[] arr) {
        int[] xor = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i){
            xor[i + 1] = xor[i] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < arr.length - 1; ++i){
            for (int k = i + 1; k < arr.length; ++k){
                if (xor[k + 1] == xor[i]){
                    count += k - i;
                }
            }
        }
        return count;
    }
}
