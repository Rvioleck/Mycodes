package LeetCode_JAVA.Greedy_Algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/candy/
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }
        int[] curCandy = new int[n];
        Arrays.fill(curCandy, 1);
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1])
                curCandy[i] = curCandy[i - 1] + 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                curCandy[i] = Math.max(curCandy[i], curCandy[i + 1] + 1);
        }
        int allCandy = 0;
        for (int c : curCandy) {
            allCandy += c;
        }
        return allCandy;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        System.out.println(new Candy().candy(ratings));
    }

}
