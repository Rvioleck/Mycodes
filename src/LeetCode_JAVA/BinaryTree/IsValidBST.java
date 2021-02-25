package LeetCode_JAVA.BinaryTree;

import java.util.Stack;

public class IsValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

//    public boolean isValidBST(TreeNode root) {
//        if (root.left == null && root.right == null){
//            return true;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        long currVal = Long.MIN_VALUE;
//        while (root != null || !stack.isEmpty()){
//            if (root != null){
//                stack.push(root);
//                root = root.left;
//            } else {
//                root = stack.pop();
//                if (currVal >= root.val){
//                    return false;
//                } else {
//                    currVal = root.val;
//                }
//                root = root.right;
//            }
//        }
//        return true;
//    }


//    private boolean validNode(TreeNode root){
//        // 单独验证每个结点是否满足二叉搜索树(无法验证全局是否是二叉搜索树)
//        if (root == null){
//            return true;
//        }
//        boolean left = validNode(root.left);
//        boolean right = validNode(root.right);
//        if (!left || !right){
//            return false;
//        }
//        boolean rootValid;
//        if (root.left != null && root.right != null){
//            rootValid = root.val > root.left.val && root.val < root.right.val;
//        } else if (root.left == null && root.right == null){
//            rootValid = true;
//        } else if (root.left == null){
//            rootValid = root.val < root.right.val;
//        } else {
//            rootValid = root.val > root.left.val;
//        }
//        return rootValid;
//    }

}
