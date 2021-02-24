package LeetCode_JAVA.BinaryTree;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new SortedArrayToBST().sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(t);
    }

}
