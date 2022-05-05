package LeetCode_JAVA.BitwiseOperation;

public class FourArithmeticOperation {

    public int add(int a, int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public int sub(int a, int b){
        return add(a, add(~b, 1));
    }

    public int mul(int a, int b){
        int res = 0;
        while (b != 0){
            if ((b & 1) == 1){
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public int div(int a, int b){
        int x = a < 0 ? -a : a;
        int y = b < 0 ? -b : b;
        int res = 0;
        for (int i = 31; i >= 0; i = sub(i, 1)){
            if ((x >> i) >= y){
                res |= (1 << i);
                x = sub(x, (y << i));
            }
        }
        return a < 0 ^ b < 0 ? -res : res;
    }


    public static void main(String[] args) {
        System.out.println(new FourArithmeticOperation().add(3, 6));
        System.out.println(new FourArithmeticOperation().sub(3, 6));
        System.out.println(new FourArithmeticOperation().mul(3, -6));
        System.out.println(new FourArithmeticOperation().div(6, -3));
    }

}
