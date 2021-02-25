package LeetCode_JAVA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.offer(root);
        boolean tag = false;
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node == null){
                if (!tag){
                    tag = true;
                }
            } else {
                if (tag){
                    return false;
                }
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsCompleteTree().isCompleteTree(TreeNode.create("[1,2,3,4,5,6]")));
    }

}
