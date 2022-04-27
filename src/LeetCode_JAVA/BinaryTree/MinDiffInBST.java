package LeetCode_JAVA.BinaryTree;

public class MinDiffInBST {

    /**
     * https://www.lintcode.com/problem/1746/description
     * @param root:  a Binary Search Tree (BST) with the root node
     * @return: the minimum difference
     */
    static long res = Integer.MAX_VALUE;
    static long preValue = Integer.MIN_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        inorder(root);
        return (int)res;
    }

    public void inorder(TreeNode root){
        if (root.left != null){ // 左
            inorder(root.left);
        }
        long diff = root.val - preValue;  // 根
        preValue = root.val;
        res = Math.min(res, diff);
        if (root.right != null){  // 右
            inorder(root.right);
        }
    }
}
