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

    class Info{
        TreeNode leftNode;
        TreeNode rightNode;
        public Info(TreeNode left, TreeNode right){
            leftNode = left;
            rightNode = right;
        }
    }

    public TreeNode treeToDoublyList2(TreeNode root){
        if (root == null || root.left == null && root.right == null){
            return root;
        }
        Info res = dfs(root);
        TreeNode mostLeft = res.leftNode, mostRight = res.rightNode;
        mostRight.right = mostLeft;
        mostLeft.left = mostRight;
        return mostRight.right;
    }

    public Info dfs(TreeNode root){
        if (root == null){
            return new Info(null, null);
        }
        Info leftTree = dfs(root.left);
        Info rightTree = dfs(root.right);
        if (leftTree.rightNode != null){
            leftTree.rightNode.right = root;
        }
        root.left = leftTree.rightNode;
        if (rightTree.leftNode != null){
            rightTree.leftNode.left = root;
        }
        root.right = rightTree.leftNode;
        return new Info(leftTree.leftNode != null ? leftTree.leftNode : root,
                rightTree.rightNode != null ? rightTree.rightNode : root);
    }



    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,3,4,5]");
        System.out.println(new TreeToDoubleList().treeToDoublyList(t));
        System.out.println(new TreeToDoubleList().treeToDoublyList2(t));
    }
}
