package Lanqiao.Provincial10th;

import java.util.*;

public class I_PostFixExpression_Java_C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        long absSum = 0, noSignSum = 0;
        int posNum = 0, negNum = 0;
        int minPos = Integer.MAX_VALUE, maxNeg = Integer.MIN_VALUE;

        for (int i = 0; i < N + M + 1; i++) {
            int val = sc.nextInt();
            noSignSum += val;
            absSum += Math.abs(val);
            if (val >= 0){
                posNum += 1;
                minPos = Math.min(val, minPos);
            } else {
                negNum += 1;
                maxNeg = Math.max(val, maxNeg);
            }
        }

        if (M == 0){
            System.out.println(noSignSum);
        } else if (posNum == 0 && M < negNum){
            System.out.println(absSum + 2L * maxNeg);
        } else if (negNum == 0 && M > negNum){
            System.out.println(absSum - 2L * minPos);
        } else {
            System.out.println(absSum);
        }
    }

}

/*
    (1)没有负号运算符：此时将所有数都加了,例如：
       5+ 0-
       1 2 3 -4 -5 -6
       ->  1 + 2 + 3 + (-4) + (-5) + (-6)
       ->  -9


    (2)一旦负号存在，负号位置就会对运算结果产生影响，那么：
       1.在无正数并且负号运算符不足参与负数运算的情况下，
       就有一个负数会单独出来和一个其它数求出来的一个绝对值和整体做减运算，负数为被减数。
       负数取最大值时值最大. 也就是所求的值等于所有绝对值的值和除去这个负数两次的值。
       例如：
       2+ 3-
       -1 -2 -3 -4 -5 -6
       ->  (-1) - ((-2) + (-3)) - ((-4) + (-5)) - (-6)
       ->  19

       2.在无负数并且负号运算符大于0，所有正整数参与运算的情况下，
       就有一个正数会单独出来和一个其它数求出来的一个绝对值和整体做减运算，正数为被减数.
       正数取最小值时值最大. 也就是所求的值等于所有绝对值的值和除去这个正数两次的值。
       例如：
       2+ 3-
       1 2 3 4 5 6
       ->   6 + 5 + 4 - (1 - 2 - 3)
       ->   19

       3. 正数和负数都在的情况下，并且负号运算存在，只要存在一个负号，就可以通过加括号让所有负数转正

*/