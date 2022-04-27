package LeetCode_JAVA.BinaryTree;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return getDepthDiff(root) != -1;
    }

    private int getDepthDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepthDiff(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepthDiff(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /*
      树形dp套路解
     */

    public static class ReturnData{
        public int height;
        public boolean isBalanced;

        public ReturnData(int hei, boolean isB){
            this.height = hei;
            this.isBalanced = isB;
        }
    }

    public boolean isBalanced1(TreeNode root) {
        return process(root).isBalanced;
    }

    public ReturnData process(TreeNode root){
        if (root == null){
            return new ReturnData(0, true);
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) <= 1;
        return new ReturnData(height, isBalanced);
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(new IsBalanced().isBalanced(t));
    }
}
