package LeetCode_JAVA;

public class GetPermutation {
    private int n, k;
    int[] fact = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public void dfs(int index, StringBuffer path, boolean[] vis){
        // 从根结点第0层index=0开始进行深度优先搜索
        if (index == this.n){
            return;
        }
        int cnt = fact[n - index - 1]; // 计算其每个子树的大小(排列组合的个数)
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            if (k > cnt){   // 若k大于该子树的大小，则必不在该子树内，继续查找
                k -= cnt;
                continue;
            }
            vis[i] = true;
            path.append(i);
            dfs(index + 1, path, vis);
            return;
        }
    }

    public String getPermutation(int n, int k) {
        boolean[] vis = new boolean[n + 1];
        this.n = n;
        this.k = k;
        StringBuffer path = new StringBuffer();
        dfs(0, path, vis);
        return new String(path);
    }

    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println(new GetPermutation().getPermutation(n, k));
    }
}
