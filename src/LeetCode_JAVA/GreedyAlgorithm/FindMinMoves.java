package LeetCode_JAVA.GreedyAlgorithm;

public class FindMinMoves {
    /*
    * https://leetcode-cn.com/problems/super-washing-machines/
    * */

    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0){
            return 0;
        }
        int sum = 0;
        for (int num: machines){
            sum += num;
        }
        if (sum % machines.length != 0){
            return -1;
        }
        int avg = sum / machines.length;
        int ans = 0;
        int leftSum = 0;
        for (int i = 0; i < machines.length; ++i){
            int leftRest = leftSum - i * avg;
            int rightRest = (sum - leftSum - machines[i]) -
                    (machines.length - 1 - i) * avg;
            if (leftRest < 0 && rightRest < 0){
                ans = Math.max(ans, -leftRest - rightRest);
            } else {
                ans = Math.max(ans, Math.max(leftRest, rightRest));
            }
            leftSum += machines[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindMinMoves().findMinMoves(new int[]{4, 3, 2, 5, 8, 2}));
    }


}
