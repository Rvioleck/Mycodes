package LeetCode_JAVA.BinaryTree;

import java.util.Stack;

public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (--k == 0){
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[5,3,6,2,4,null,null,1]");
        System.out.println(new KthSmallest().kthSmallest(t, 3));
    }
}
