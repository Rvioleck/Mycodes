package LeetCode_JAVA.BitwiseOperation;

public class Add {

    public static void main(String[] args) {
        System.out.println(new Add().add(0b10, 0b11));
        System.out.println(new Add().add0(0b10, 0b11));
    }

    /**
     * @param a a^b 数a和数b的按位异或，保留无进制加法
     * @param b (a&b) << 1 数a和数b的与结果左移，保留加法的进位
     * @return 递归解决a+b, a是无进制加法，b是其对应的进位，递归到进位为0时，a即为求和结果
     */
    public int add0(int a, int b){
        return b == 0 ? a : add0(a^b, (a&b) << 1);
    }

    /**
     * @param a 数a
     * @param b 数b
     * @return a+b
     */
    public int add(int a, int b) {
        boolean tag = false;
        int res = 0;
        int mark = 1;
        for (int i = 0; i < 32; ++i){
            int aBit = (a&1), bBit = (b&1);
            if (aBit == 1 && bBit == 0 || aBit == 0 && bBit == 1){
                if (!tag){
                    res ^= mark;
                }
            } else if (aBit == 1 && bBit == 1){
                if (!tag){
                    tag = true;
                } else {
                    res ^= mark;
                }
            } else if (aBit == 0 && bBit == 0){
                if(tag){
                    tag = false;
                    res ^= mark;
                }
            }
            a >>>= 1;
            b >>>= 1;
            mark <<= 1;
        }
        return res;
    }
}
