package LeetCode_JAVA.BinaryTree;

public class AverageOfSubtree {

    static class Info{
        int sum; // 子树和
        int res; // 子树题目结果
        int nodes; // 子树结点个数
        Info(int sum, int res, int nodes){
            this.sum = sum;
            this.res = res;
            this.nodes = nodes;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        return dfs(root).res;
    }

    public Info dfs(TreeNode root){
        if (root == null){
            return new Info(0, 0, 0);
        }
        if (root.left == null && root.right == null){
            return new Info(root.val, 1, 1);
        }
        Info left = dfs(root.left);
        Info right = dfs(root.right);
        int sum = left.sum + right.sum + root.val;
        int nodes = left.nodes + right.nodes + 1;
        int rootRes = sum / nodes == root.val ? 1 : 0;
        return new Info(sum, rootRes + left.res + right.res, nodes);
    }

}
