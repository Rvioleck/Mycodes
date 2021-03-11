package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindTarget {

    List<Integer> nums = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        inorder(root);
        int i = 0, j = nums.size() - 1;
        while (i < j){
            int left = nums.get(i), right = nums.get(j);
            if (left + right < k){
                i++;
            } else if (left + right > k){
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inorder(TreeNode root) {
        if (root != null){
            inorder(root.left);
            nums.add(root.val);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
//        TreeNode t = TreeNode.create("[5,3,6,2,4,null,7]");
        TreeNode t = TreeNode.create("[2,1,3]");
        System.out.println(new FindTarget().findTarget(t, 1));
    }

}
