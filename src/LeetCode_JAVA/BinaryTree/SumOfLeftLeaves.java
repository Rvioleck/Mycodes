package LeetCode_JAVA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.left != null){
                if (root.left.left == null && root.left.right == null){
                    res += root.left.val;
                }
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(TreeNode.create("[3,9,20,null,null,15,7]")));
    }
}
