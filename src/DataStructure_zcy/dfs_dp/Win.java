package DataStructure_zcy.dfs_dp;

public class Win {
    /*
    * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。
    * 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿
    * 但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。
    * 请返回最后获胜者的分数。
    * */

    public int win1(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1),
                        s(arr, 0, arr.length - 1));
    }

    public int f(int[] arr, int i, int j){
        if (i == j) return arr[i];
        return Math.max(arr[i] + s(arr, i + 1, j),
                        arr[j] + s(arr, i, j - 1));
    }

    public int s(int[] arr, int i, int j){
        if (i == j) return 0;
        return Math.min(f(arr, i + 1, j),
                        f(arr, i, j - 1));
    }

    // dp
    public int win2(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; ++i){
            f[i][i] = arr[i];
        }
        int row = 0, col = 1;
        while (col < arr.length){
            int i = row;
            int j = col;
            while (i < arr.length && j < arr.length){
                f[i][j] = Math.max(arr[i] + s[i + 1][j],
                                   arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j],
                                   f[i][j - 1]);
                i++;
                j++;
            }
            col++;
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

}
