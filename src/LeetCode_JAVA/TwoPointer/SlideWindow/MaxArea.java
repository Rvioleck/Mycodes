package LeetCode_JAVA.TwoPointer.SlideWindow;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int i = 0; // 容器的左边界
        int j = height.length - 1; // 容器的右边界
        int maxWater = 0;
        int curWater = 0;
        while (i < j){
            curWater = getArea(height, i, j);
            maxWater = Math.max(maxWater, curWater);
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
    }

    int getArea(int[] height, int i, int j){
        // 通过左右边界计算出水的容量
        return (j - i) * Math.min(height[i], height[j]);
    }
}
