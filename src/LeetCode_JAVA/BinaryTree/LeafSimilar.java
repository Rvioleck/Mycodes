package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.create("[3,5,1,6,2,9,8,null,null,7,4]");
        TreeNode t2 = TreeNode.create("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]");
        System.out.println(new LeafSimilar().leafSimilar(t1, t2));
    }

    public List<Integer> getLeafSequence(TreeNode root){
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = getLeafSequence(root1);
        List<Integer> res2 = getLeafSequence(root2);
        return res1.equals(res2);
    }

}
