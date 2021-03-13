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
        // 输入整数N和数组nums
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        // 调用排序算法(算法比赛直接调用接口即可)
        Arrays.sort(nums); // 升序
        // getDeltaFactor方法求相邻元素差的最大公因子
        // 例：2, 6, 12, 差为(4, 6) 最大公因子为2
        // 例：2, 4, 7, 差为(2, 3) 最大公因子为1
        // 例：2, 4, 6, 10, 20, 差为(2, 4, 10) 最大公因子为2
        int deltaFactor = new H_ArithmeticalSequence_C().getDeltaFactor(nums);
        // 等差数列公式 an = a1 + (n - 1) * d
        // 元素个数 n = (an - a1) / d + 1
        int count = (nums[N - 1] - nums[0]) / deltaFactor + 1;
        System.out.println(count);
    }

    /**
     * @param nums 数组nums记录所有的元素
     * @return 数组相邻元素的差的最大共因子
     */
    private int getDeltaFactor(int[] nums) {
        TreeSet<Integer> deltaSet = new TreeSet<>(); // TreeSet存储数列元素的差
        // (set的特点是元素不重复) TreeSet为排序集合，每次添加元素会自动维持顺序插入新元素

        for (int i = 1; i < nums.length; i++) {      // 找到任意相邻元素的间隔delta
            int currDelta = nums[i] - nums[i - 1];
            deltaSet.add(currDelta);  // 所有相邻元素的差添加进deltaSet，若重复Set会自动保留一个
        }
        int minDelta = deltaSet.first(); // TreeSet特性，第一个元素为集合中最小值
                                         // C++的类似接口如果不了解，也可以直接用Set后，再单独遍历一次找最小值

        outer : while (minDelta > 1) {  //
            for (int delta : deltaSet) { // for-each对delta集合里面的元素进行遍历
                if (delta % minDelta != 0){
                    // 若minDelta不是任何一个元素delta的因子，则就不是公因子
                    minDelta--; // minDelta-- 后继续外层循环继续搜寻minDelta—1是否满足
                    continue outer;
                }
            }
            // 如果当前的minDelta顺利完成上述for循环，则当前minDelta为所有差的最大公因子
            return minDelta;
        }
        // 上述均不满足，则最大公因子就为1
        return 1;
    }

}
