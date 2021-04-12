package LeetCode_JAVA.BinaryTree;

public class IsSubtree {

    private boolean isEquals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        return isEquals(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    public static void main(String[] args) {
        TreeNode s = TreeNode.create("[3,4,5,1,2]");
        TreeNode t = TreeNode.create("[4,1,2]");
        boolean res = new IsSubtree().isSubtree(s, t);
        System.out.println(res);
    }

}
