package LeetCode_JAVA.TwoPointer;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class JudgeSquareSum {

    public static void main(String[] args) {
        int c = 10;
        System.out.println(new JudgeSquareSum().judgeSquareSum(c));
    }

    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right){
            int sum = left * left + right * right;
            if (sum == c){
                return true;
            } else if (sum > c){
                right--;
            } else left++;
        }
        return false;
    }

}
