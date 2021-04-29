package LeetCode_JAVA.DisjointSet;

import org.junit.Test;

import java.util.Arrays;

public class DisjointSet {

    /**
     * 初始化parent数组全为-1(表示所有结点自身为父结点)
     *
     * @param parent 记录所有元素的父结点下标，自身为父结点则值为-1
     */
    public void initialise(int[] parent, int[] rank) {
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);
    }

    /**
     * 不断搜寻结点x的父结点直到找到其根节点x_root
     *
     * @param x      被搜寻的结点x
     * @param parent 记录所有元素的父结点下标，自身为父结点则值为-1
     * @return 结点x的根节点x_root
     */
    public int findRoot(int x, int[] parent) {
        int x_root = x;
        while (parent[x_root] != -1) {
            x_root = parent[x_root];
        }
        return x_root;
    }

    /**
     * @param x1     所合并的结点x1
     * @param x2     所合并的结点x2
     * @param parent 记录所有元素的父结点下标，自身为父结点则值为-1
     * @param rank   记录所有元素的子树高，自身为叶结点则值为0
     * @return 是否完成合并
     */
    public boolean union(int x1, int x2, int[] parent, int[] rank) {
        int x_root = findRoot(x1, parent);
        int y_root = findRoot(x2, parent);
        if (x_root == y_root) {
            return false;
        }
        if (rank[x_root] > rank[y_root]) {
            parent[y_root] = x_root;
        } else if (rank[y_root] > rank[x_root]) {
            parent[x_root] = y_root;
        } else {
            parent[x_root] = y_root;
            rank[y_root]++;
        }
        return true;
    }

    @Test
    public void test() {
        final int VERTICES = 100;
        int[] parent = new int[VERTICES];
        int[] rank = new int[VERTICES];
        initialise(parent, rank);
        int[][] edges = {
                {0, 1}, {1, 2}, {1, 3},
                {2, 4}, {3, 4}, {2, 5}
        };
        for (int[] edge : edges) {
            int x1 = edge[0], x2 = edge[1];
            if (!union(x1, x2, parent, rank)) {
                System.out.println("Cycle detected!");
                System.exit(0);
            }
        }
        System.out.println("No cycle!");
    }

}
