package LeetCode_JAVA.BinaryTree;

public class CountNodes {
    /*
    * https://leetcode.cn/problems/count-complete-tree-nodes/
    * */

    public int countNodes(TreeNode root) {
        int rootHeight = getHeight(root);
        return dfs(root, rootHeight);
    }

    public int dfs(TreeNode root, int height){
        if (root == null){
            return 0;
        }
        int res = 0;
        if (height == getHeight(root.right) + 1){ // 右树的最左结点是否是最低层结点
            // 左树为满二叉树，直接计算，递归右树
            res += (1 << (height - 1)) + dfs(root.right, height - 1);
        } else {
            // 右树为满二叉树，直接计算，递归左树
            res += (1 << (height - 2)) + dfs(root.left, height - 1);
        }
        return res;
    }

    public int getHeight(TreeNode root){
        // 计算完全二叉树的高度
        int height = 0;
        while (root != null){
            root = root.left;
            height++;
        }
        return height;
    }

}
