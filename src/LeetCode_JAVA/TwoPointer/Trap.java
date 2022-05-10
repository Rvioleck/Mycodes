package LeetCode_JAVA.TwoPointer;

public class Trap {
    /*
     * https://leetcode-cn.com/problems/trapping-rain-water/
     * */

    public int trap(int[] height) {
        // 时间复杂度O(n)，空间复杂度O(n)
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; ++i) {
            leftmax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; --i) {
            rightmax[i] = max;
            max = Math.max(max, height[i]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            res += Math.max(Math.min(leftmax[i], rightmax[i]) - height[i], 0);
        }
        return res;
    }

    public int trap2(int[] height){
        // 时间复杂度O(n)，空间复杂度O(1)
        int i = 0, j = height.length - 1;
        int L = 0, R = height.length - 1;
        int res = 0;
        while (i <= j){
            if (height[L] <= height[R]){
                if (height[i] < height[L]){
                    res += height[L] - height[i];
                } else {
                    L = i;
                }
                i++;
            } else {
                if (height[j] < height[R]){
                    res += height[R] - height[j];
                } else {
                    R = j;
                }
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(new Trap().trap2(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
