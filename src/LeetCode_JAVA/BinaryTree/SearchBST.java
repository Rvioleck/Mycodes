package LeetCode_JAVA.BinaryTree;

public class SearchBST {

    /*
    * https://www.lintcode.com/problem/1524/
    * 查找二叉树中特定结点
    * */

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val){
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[4,2,7,1,3]");
        System.out.println(new SearchBST().searchBST(t, 2));
    }

}
