package LeetCode_JAVA.BinaryTree;

public class BuildTree3 {
    int[] pre, post;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return buildTree(0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode buildTree(int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight){
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        if (preLeft == preRight){ // 防止下面preLeft + 1溢出
            return root;
        }

        int index = postLeft; // 此时的index已经是postLeft的偏移量了
        while (pre[preLeft + 1] != post[index]){
            index++;
        }

        root.left = buildTree(preLeft + 1, preLeft + 1 + index - postLeft, postLeft, index);
        root.right = buildTree(preLeft + index - postLeft + 2, preRight, index + 1, postRight - 1);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode t = new BuildTree3().constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
        TreeNode t = new BuildTree3().constructFromPrePost(new int[]{1}, new int[]{1});
        System.out.println(t);
    }

}
