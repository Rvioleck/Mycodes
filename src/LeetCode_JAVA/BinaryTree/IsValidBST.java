package LeetCode_JAVA.BinaryTree;

import java.util.Stack;

public class IsValidBST {
    long pre = Long.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[0]");
        System.out.println(new IsValidBST().isValidBST(t));
    }

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

    public boolean isValidBST1(TreeNode root) {
        // 非递归实现
        if (root == null) return true;
        long preVal = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (preVal >= root.val) return false;
                preVal = (long) root.val;
                root = root.right;
            }
        }
        return true;
    }

    /*
       树形dp套路实现
     */

    public static class ReturnData{
        public boolean isBST;
        public int max;
        public int min;

        ReturnData(boolean isB, int max, int min){
            this.isBST = isB;
            this.max = max;
            this.min = min;
        }

    }

    public boolean isValidBST2(TreeNode root) {
        return process(root).isBST;
    }

    public ReturnData process(TreeNode root){
        if (root == null){
            return null;
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int max = rightData != null ? Math.max(root.val, rightData.max) : root.val;
        int min = leftData != null ? Math.min(root.val, leftData.min) : root.val;
        boolean isBST = (leftData == null || (leftData.isBST && leftData.max < root.val)) &&
                (rightData == null || (rightData.isBST && rightData.min > root.val));
        return new ReturnData(isBST, max, min);
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
