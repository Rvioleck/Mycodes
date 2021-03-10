package Lanqiao.Provincial10th;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class H_ArithmeticalSequence_C {

    /*
       5
       2 6 4 10 20
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int deltaFactor = new H_ArithmeticalSequence_C().getDeltaFactor(nums);
        int count = (nums[N - 1] - nums[0]) / deltaFactor + 1;
        System.out.println(count);
    }

    private int getDeltaFactor(int[] nums) {
        TreeSet<Integer> deltaSet = new TreeSet<>();
        for (int i = 1; i < nums.length; i++) {  // 找到任意相邻元素的间隔delta
            int currDelta = nums[i] - nums[i - 1];
            deltaSet.add(currDelta);
        }
        int minDelta = deltaSet.first();
        outer : while (minDelta >= 1) {
            for (int delta : deltaSet) {
                if (delta % minDelta != 0){
                    minDelta--;
                    continue outer;
                }
            }
            return minDelta;
        }
        return 1;
    }

}
