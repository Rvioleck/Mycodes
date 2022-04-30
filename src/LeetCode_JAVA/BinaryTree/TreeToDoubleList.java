package LeetCode_JAVA.BinaryTree;

import java.util.Stack;

public class TreeToDoubleList {

    /**
     * https://www.lintcode.com/problem/1577/
     * 二叉线索树转有序双向链表
     */


    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        TreeNode head = new TreeNode(0);
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                TreeNode right = root.right;
                root.left = cur;
                cur.right = root;
                cur = root;
                root = right;
            }
        }
        cur.right = head.right;
        head.right.left = cur;
        return cur.right;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,3,4,5]");
        System.out.println(new TreeToDoubleList().treeToDoublyList(t));
    }
}
