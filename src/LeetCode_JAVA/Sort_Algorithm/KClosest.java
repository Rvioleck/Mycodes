package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 */
public class KClosest {

    public int[][] kClosest(int[][] points, int K) {
        // 自定义排序法
        Arrays.sort(points, (x, y) -> (int) (
                Math.pow(x[0], 2) + Math.pow(x[1], 2) -
                        (Math.pow(y[0], 2) + Math.pow(y[1], 2))
        ));
        return Arrays.copyOf(points, K);
    }

    public static void main(String[] args) {
        int[][] res = new KClosest().kClosest(new int[][]{
                {1, 2},
                {2, 0},
                {-2, 2},
                {3, 1},
                {4, 0},
                {1, -1}
        }, 3);
        for (int[] one :
                res) {
            System.out.println(Arrays.toString(one));
        }
    }

}
