package LeetCode_JAVA.BitwiseOperation;

import java.util.Arrays;

public class XorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] xorMark = new int[arr.length];
        xorMark[0] = arr[0];
        for (int i = 1; i < arr.length; ++i){
            xorMark[i] = xorMark[i - 1] ^ arr[i];
        }
        int j = 0;
        for (int[] querie : queries){
            if (querie[0] == 0){
                res[j++] = xorMark[querie[1]];
            } else{
                res[j++] = xorMark[querie[0] - 1] ^ xorMark[querie[1]];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = new int[][]{
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };
        System.out.println(Arrays.toString(new XorQueries().xorQueries(arr, queries)));
    }

}
