package DataStructure_zcy;

public class String2Integer {

    /*
    * 实现String.parseInt(str)
    * */

    public int convert(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        if (!isValid(str)){
            throw new RuntimeException("can not convert");
        }
        boolean neg = str[0] == '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = neg ? 1 : 0; i < str.length; ++i){
            cur = '0' - str[i];
            if ((res < minq) || (res == minq && cur < minr)){
                throw new RuntimeException("can not convert");
            }
            res = res * 10 + cur;
        }
        if (!neg && res == Integer.MIN_VALUE){
            // res == Integer.MAX_VALUE + 1
            throw new RuntimeException("can not convert");
        }
        return neg ? res : -res;
    }

    private boolean isValid(char[] str) {
        if (str[0] != '-' && (str[0] < '0' || str[0] > '9')){
            return false;
        }
        if (str[0] == '-' && (str.length == 1 || str[1] == '0')){
            return false;
        }
        if (str[0] == '0' && str.length > 1){
            return false;
        }
        for (int i = 1; i < str.length; ++i) {
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new String2Integer().convert("-23214"));
    }

}
