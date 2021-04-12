package LeetCode_JAVA.BinaryTree;

public class Flatten {

    public void flatten(TreeNode root) {
        build(root);
    }

    private TreeNode build(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = build(root.left);
        root.right = build(root.right);

        TreeNode rChild = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null)
            cur = cur.right;
        cur.right = rChild;
        return root;
    }

    public static void main(String[] args) {
//        TreeNode t = TreeNode.create("[2]");
        TreeNode t = TreeNode.create("[1,2,5,3,4,null,6]");
        new Flatten().flatten(t);
    }

}
