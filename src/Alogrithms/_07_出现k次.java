package Alogrithms;

/**
 * 在一个数组中有一个数字出现1次，剩余所有的数字出现k次，找到出现一次的数字
 * k个相同的数进行k进制的不进位加法为0，则全加之后为为唯一出现的一个数字
 */
public class _07_出现k次 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 2, 2, 7, 7, 3, 3, 7, 3, 6, 6, 6, 0, 0, 0};
        int len = arr.length;
        char[][] kRadix = new char[len][];
        int k = 3;
        // 转成k进制字符数组
        int maxLen = 0; // 记录最长k进制数字的位数
        // 对于每个数字
        for (int i = 0; i < len; i++) {
            // 求每个数字的k进制并翻转，然后转为字符数组
            // 翻转是为了易于进行低位求和 如：三进制221,21,1相加对于字符数组需要翻转从下标0开始低位相加
            kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            maxLen = Math.max(maxLen, kRadix[i].length);
        }
        int[] resArr = new int[maxLen]; // 记录k进制加法求和后的每一位
        // 进行不进位加法
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < maxLen; j++) {
                if (j >= kRadix[i].length){
                    resArr[j] += 0;
                } else {
                    resArr[j] += (kRadix[i][j] - '0');
                }
            }
        }
        int res = 0; // k进制结果转为十进制
        for (int i = 0; i < maxLen; i++) {
            res += (resArr[i] % k) * (int)Math.pow(k, i);
        }
        System.out.println(res);
    }

}
