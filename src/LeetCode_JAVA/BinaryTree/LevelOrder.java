package LeetCode_JAVA.BinaryTree;

import java.util.*;

public class LevelOrder {
    private final List<Integer> res = new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        TreeNode node;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    private final List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root){
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.add(root);
        int size = queue.size();
        while (!queue.isEmpty()){
            List<Integer> oneLevel = new ArrayList<>();
            while (size-- > 0){
                node = queue.remove();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                oneLevel.add(node.val);
            }
            size = queue.size();
            list.add(oneLevel);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(Arrays.toString(new LevelOrder().levelOrder(t1)));
        System.out.println(new LevelOrder().levelOrder2(t1));
    }

}
