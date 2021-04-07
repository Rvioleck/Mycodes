package LeetCode_JAVA.TwoPointer;

public class Search {

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target || nums[n - i - 1] == target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(new Search().search(nums, target));
    }

}
