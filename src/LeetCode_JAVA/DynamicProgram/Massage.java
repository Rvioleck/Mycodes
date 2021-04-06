package LeetCode_JAVA.DynamicProgram;

public class Massage {

    public int massage(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int even = 0, odd = nums[0];
        for (int i = 1; i < len; i++) {
            int even0 = Math.max(odd, even), odd0 = even0 + nums[i];
            even = even0;
            odd = odd0;
        }
        return Math.max(odd, even);
    }

    public static void main(String[] args) {
        System.out.println(new Massage().massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

}
