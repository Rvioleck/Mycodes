package LeetCode_JAVA.TwoPointer;


import java.util.Arrays;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i <= j){
            int left = numbers[i], right = numbers[j];
            if (left + right > target){
                j--;
            } else if(left + right < target){
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum2().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

}
