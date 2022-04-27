package LeetCode_JAVA.BinaryTree;

import java.util.Stack;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int l, int r) {
        // O(n)
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int res = 0;
        boolean flag = false;
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val == l){
                    flag = true;
                }else if (root.val == r){
                    res += r;
                    return res;
                }
                if (flag){
                    res += root.val;
                }
                root = root.right;
            }
        }
        return res;
    }

    public int rangeSumBST1(TreeNode root, int l, int r){
        // O(logN)
        if (root == null) return 0;
        if (root.val < l){
            return rangeSumBST1(root.right, l, r);
        } else if (root.val > r){
            return rangeSumBST1(root.left, l, r);
        } else {
            return root.val + rangeSumBST1(root.left, l, r) + rangeSumBST1(root.right, l, r);
        }
    }

}
