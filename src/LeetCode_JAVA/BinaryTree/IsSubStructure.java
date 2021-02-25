package LeetCode_JAVA.BinaryTree;

public class IsSubStructure {

    private boolean hasSub(TreeNode A, TreeNode B) {
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        return A.val == B.val && hasSub(A.left, B.left) && hasSub(A.right, B.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        return hasSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    public static void main(String[] args) {
        TreeNode A = TreeNode.create("[3,4,5,1,2]");
        TreeNode B = TreeNode.create("[4,1]");
        System.out.println(new IsSubStructure().isSubStructure(A, B));
    }

}
