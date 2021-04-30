package LeetCode_JAVA.BitwiseOperation;

public class SingleNumber2 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,1,99};
        System.out.println(new SingleNumber2().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; ++i){
            int digit = 1 << i;
            int digitSum = 0;
            for (int num : nums){
                if ((num & digit) != 0){
                    digitSum++;
                }
            }
            if (digitSum % 3 == 1){
                ret |= digit;
            }
        }
        return ret;
    }
}
