package LeetCode_JAVA.BinaryTree;


import java.util.HashMap;
import java.util.Map;

public class BuildTree2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen= inorder.length;
        int postLen = postorder.length;
        Map<Integer, Integer> map = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postLen - 1,
                map, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight,
                               Map<Integer, Integer> map, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight){
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = buildTree(postorder, postLeft, rootIndex - inLeft - 1 + postLeft,
                map, inLeft, rootIndex - 1);
        root.right = buildTree(postorder, rootIndex - inLeft + postLeft, postRight - 1,
                map, rootIndex + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new BuildTree2().buildTree(new int[]{9,3,15,20,7} , new int[]{9,15,7,20,3});
        System.out.println(t);
    }
}
