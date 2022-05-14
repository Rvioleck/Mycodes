package LeetCode_JAVA.BitwiseOperation;

public class MinBitFlips {

    public int minBitFlips(int start, int goal) {
        int sum = 0;
        for (int i = 0; i < 32; ++i){
            int bit = (1 << i);
            if ((start & bit) != (goal & bit)){
                sum++;
            }
        }
        return sum;
    }

    public int minBitFlips2(int start, int goal) {
        int odd = start ^ goal, sum = 0;
        for (int i = 0; i < 32; ++i){
            if (((odd >> i) & 1) == 1){
                sum++;
            }
        }
        return sum;
    }

}
