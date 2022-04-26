package LeetCode_JAVA.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_iterate {

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null){
                if (root != null){  // 当前树非空，左树进栈
                    stack.push(root);
                    root = root.left;
                } else {  // 当前树为空，弹栈输出，右树进栈
                    root = stack.pop(); // 左
                    res.add(root.val);  // 中
                    root = root.right;  // 右
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(new InorderTraversal_iterate().inOrderTraversal(t1));
    }

}
