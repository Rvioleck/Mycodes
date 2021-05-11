package LeetCode_JAVA.BitwiseOperation;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/decode-xored-permutation/
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。
 * 比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 */
public class Decode {

    public static void main(String[] args) {
        int[] encoded = new int[]{6,5,4,6};
        System.out.println(Arrays.toString(new Decode().decode(encoded)));
    }

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int allXor = 0;
        for (int i = 1; i <= n; ++i){
            allXor ^= i;
        }
        for (int i = 1; i < encoded.length; i += 2){
            allXor ^= encoded[i];
        }
        int[] decodes = new int[n];
        decodes[0] = allXor;
        for (int i = 1; i < n; ++i){
            decodes[i] = decodes[i - 1] ^ encoded[i - 1];
        }
        return decodes;
    }

}
