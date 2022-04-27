package LeetCode_JAVA.BinaryTree;

public class IsFullTree {

    /*
      树形dp解
     */

    public static class ReturnData{
        public int height;
        public int nodes;
        public ReturnData(int height, int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }

    public boolean isFullTree(TreeNode root){
        if (root == null) return true;
        ReturnData data = process(root);
        return data.nodes == (1 >> data.height) - 1;
    }

    public ReturnData process(TreeNode root){
        if (root == null) return new ReturnData(0, 0);
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        return new ReturnData(Math.max(leftData.height, rightData.height) + 1,
                leftData.nodes + rightData.nodes + 1);
    }


    public static void main(String[] args) {
        TreeNode t = TreeNode.create("[3,9,20,null,null,15,7]");
        System.out.println(new IsFullTree().isFullTree(t));
    }
}
