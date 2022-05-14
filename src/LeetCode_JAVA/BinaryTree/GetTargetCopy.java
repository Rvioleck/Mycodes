package LeetCode_JAVA.BinaryTree;

import java.util.Stack;

public class GetTargetCopy {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode[]> stack = new Stack<>();
        TreeNode[] arr = new TreeNode[2];
        arr[0] = original;
        arr[1] = cloned;
        stack.push(arr);
        while (!stack.isEmpty()){
            TreeNode[] nodes = stack.pop();
            if (nodes[0] == target){
                return nodes[1];
            }
            if (nodes[1].right != null){
                arr[0] = nodes[0].right;
                arr[1] = nodes[1].right;
                stack.push(arr);
            }
            if (nodes[0].left != null){
                arr[0] = nodes[0].left;
                arr[1] = nodes[1].left;
                stack.push(arr);
            }
        }
        return null;
    }

}
