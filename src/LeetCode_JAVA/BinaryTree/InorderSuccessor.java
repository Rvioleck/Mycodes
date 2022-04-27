package LeetCode_JAVA.BinaryTree;

public class InorderSuccessor {
    /*
     * https://leetcode-cn.com/problems/P5rCT8/
     * */

    // 全局变量，记录当前结点的前驱结点
    // 当前驱结点为p时，当前结点root则为p的后继
    public static TreeNode preNode = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root != null && root.left != null) { // 左
            TreeNode leftNode = inorderSuccessor(root.left, p);
            // 若不为null，则找到了p的后继，层层返回，不必继续中序遍历
            if (leftNode != null) return leftNode;
        }
        // 前一个结点为p时，由于是中序遍历，当前结点root就是p的后继，返回即可
        if (preNode == p) return root; // 根
        preNode = root;
        if (root != null && root.right != null) { // 右
            TreeNode rightNode = inorderSuccessor(root.right, p);
            // 若不为null，则找到了p的后继，层层返回，不必继续中序遍历
            if (rightNode != null) return rightNode;
        }
        // 此时返回的null告诉上层递归，此时仍未找到结果，继续中序遍历
        return null;
    }

}
