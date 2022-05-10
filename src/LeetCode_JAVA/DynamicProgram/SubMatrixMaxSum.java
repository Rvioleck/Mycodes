package LeetCode_JAVA.DynamicProgram;

public class SubMatrixMaxSum {
    /*
    * 最大子矩阵累加和
    * */

    public int maxSum(int[][] m){
        // 输入矩阵为m×n，时间复杂度：O(m^2*n)
        if (m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur;
        int[] s;
        for (int i = 0; i < m.length; ++i){
            s = new int[m[0].length];
            for (int j = i; j < m.length; ++j){
                cur = 0;
                for (int k = 0; k < s.length; ++k){
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }

}
