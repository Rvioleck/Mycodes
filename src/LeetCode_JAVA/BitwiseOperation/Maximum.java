package LeetCode_JAVA.BitwiseOperation;

public class Maximum {

    public int flip(int n){
        return n ^ 1;
    }

    public int sign(int n){
        return flip((n >> 31) & 1);
    }

    public int maximum(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb; // a和b符号不一样为1
        int sameSab = flip(difSab); // a和b的符号一样为1
        // ab符号相反且a的符号为正 或 ab符号相同且c的符号为正
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static void main(String[] args) {
        System.out.println(new Maximum().maximum(9, -1));
    }

}
