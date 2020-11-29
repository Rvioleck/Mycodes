package LeetCode_JAVA;

public class HammingWeight {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        HammingWeight hm = new HammingWeight();
        int a = 0b00000000000000000000000000001011;
        System.out.println(hm.hammingWeight(a));
    }
}
