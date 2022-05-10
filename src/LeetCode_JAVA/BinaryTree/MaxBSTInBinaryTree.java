package LeetCode_JAVA.BinaryTree;

public class MaxBSTInBinaryTree {

    /*
     * 找到二叉树中最大二叉搜索子树的头结点
     * */

    class Info {
        public TreeNode maxBSTHead;
        public boolean isBST;
        public int min, max;
        public int maxBSTSize;

        public Info(TreeNode head, boolean isbst, int mi, int ma, int size) {
            maxBSTHead = head;
            isBST = isbst;
            min = mi;
            max = ma;
            maxBSTSize = size;
        }
    }

    public TreeNode findMaxBSTInBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(root).maxBSTHead;
    }

    public Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(null, true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info leftTree = dfs(root.left);
        Info rightTree = dfs(root.right);
        int min = Math.min(leftTree.min, rightTree.min);
        min = Math.min(min, root.val);
        int max = Math.max(leftTree.max, rightTree.max);
        max = Math.max(max, root.val);
        TreeNode maxBSTHead = null;
        boolean isBST = false;
        int maxBSTSize = 0;
        if (leftTree.isBST) {
            maxBSTHead = leftTree.maxBSTHead;
            maxBSTSize = leftTree.maxBSTSize;
            if (rightTree.isBST && leftTree.maxBSTSize < rightTree.maxBSTSize) {
                maxBSTHead = rightTree.maxBSTHead;
                maxBSTSize = rightTree.maxBSTSize;
            }
            if (rightTree.isBST && root.val > leftTree.max && root.val < rightTree.min) {
                maxBSTHead = root;
                maxBSTSize = leftTree.maxBSTSize + rightTree.maxBSTSize + 1;
                isBST = true;
            }
        } else if (rightTree.isBST) {
            maxBSTHead = rightTree.maxBSTHead;
            maxBSTSize = rightTree.maxBSTSize;
        } else {
            maxBSTHead = leftTree.maxBSTSize >= rightTree.maxBSTSize ? leftTree.maxBSTHead : rightTree.maxBSTHead;
            maxBSTSize = Math.max(leftTree.maxBSTSize, rightTree.maxBSTSize);
        }
        return new Info(maxBSTHead, isBST, min, max, maxBSTSize);
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[0,5,6,2,6,8,9,1,7]");
        System.out.println(new MaxBSTInBinaryTree().findMaxBSTInBinaryTree(t));
    }

}
