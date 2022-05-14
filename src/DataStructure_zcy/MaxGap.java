package DataStructure_zcy;

public class MaxGap {

    public int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j : nums) {
            min = Math.min(min, j);
            max = Math.max(max, j);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid;
        for (int num : nums) {
            bid = ((num - min) * len / (max - min));
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], num) : num;
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], num) : num;
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; ++i) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxGap().maxGap(new int[]{2,5,1,7,4,8,9,0}));
    }

}
