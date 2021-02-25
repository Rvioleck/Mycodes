package LeetCode_JAVA.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class IsCousins {
    Map<Integer, Integer> depth = new HashMap<>();
    Map<Integer, TreeNode> parent = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null){
            return false;
        }
        dfs(root, null, 0);
        return depth.get(x).equals(depth.get(y)) && parent.get(x) != parent.get(y);
    }

    private void dfs(TreeNode root, TreeNode par, int dep){
        if (root != null){
            depth.put(root.val, dep);
            parent.put(root.val, par);
            dfs(root.left, root, dep + 1);
            dfs(root.right,root,  dep + 1);
        }
    }

}
