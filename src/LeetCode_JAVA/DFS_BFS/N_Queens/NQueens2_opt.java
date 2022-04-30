package LeetCode_JAVA.DFS_BFS.N_Queens;

public class NQueens2_opt {

    /*
     * 位运算加速n皇后问题的常数运算
     * */

    public int totalNQueens(int n) {
        // int型二进制只能表示32位，因此解决1~32皇后问题
        if (n < 1 || n > 32) return 0;
        // 生成后n位1，剩余位0的limit，仅使用位信息
        int limit = n == 32 ? -1 : (1 << n) - 1; // 全程不被修改
        return dfs(limit, 0, 0, 0);
    }

    public int dfs(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        // colLim, leftDiaLim, rightDiaLim的位为1表示此位不能选
        if (limit == colLim) {
            return 1;
        }
        // pos的为1表示此位可以填皇后
        // 与limit相与为了把高位的1给置0，限制可以选皇后的位置不越界
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne; // 记录候选位置中最右侧的1
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos -= mostRightOne;
            res += dfs(limit, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(new NQueens2_opt().totalNQueens(n));
    }

}
