package LeetCode_JAVA.BinaryTree;

import java.util.Stack;

public class IncreasingBST {
    /**
     * https://www.lintcode.com/problem/1744/
    * */

    public TreeNode increasingBST(TreeNode root) {
        // Write your code here.
        TreeNode head = new TreeNode(0);
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                TreeNode right = root.right;
                cur.left = null;
                cur.right = root;
                cur = root;
                root = right;
            }
        }
        cur.left = null;
        return head.right;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[8,3,10,1,6,null,14,null,null,4,7,13,null]");
        System.out.println(t);
        System.out.println(new IncreasingBST().increasingBST(t));
    }
}
