package LeetCode_JAVA.BinaryTree;

public class HasPathSum {
    private boolean result = false;
    private int sum;

    private void dfs(TreeNode root, int curSum){
        if (root == null || result){
            return;
        }
        curSum += root.val;
        if (root.left == null && root.right == null){
            if (curSum == sum){
                result = true;
            }
            return;
        }
        dfs(root.left, curSum);
        dfs(root.right, curSum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        this.sum = sum;
        dfs(root, 0);
        return result;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println(new HasPathSum().hasPathSum(t, 22));
    }

}
