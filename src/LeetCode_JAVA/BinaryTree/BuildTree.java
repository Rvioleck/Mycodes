package LeetCode_JAVA.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        Map<Integer, Integer> map = new HashMap<>(preLen);
        for (int i = 0; i < preLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = buildTree(preorder, preLeft + 1, rootIndex - inLeft + preLeft,
                map, inLeft, rootIndex - 1);
        root.right = buildTree(preorder, rootIndex - inLeft + preLeft + 1, preRight,
                map, rootIndex + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new BuildTree().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(t);
    }
}
