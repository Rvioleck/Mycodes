package LeetCode_JAVA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumNumbers {

    /*
    * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
    * */

    public int sumNumbers(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.left == null && root.right == null){
                res += root.val;
                continue;
            }
            if (root.left != null){
                queue.offer(root.left);
                root.left.val += root.val * 10;
            }
            if (root.right != null){
                queue.offer(root.right);
                root.right.val += root.val * 10;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[1,2,3]");
        System.out.println(new SumNumbers().sumNumbers(t));
    }
}
