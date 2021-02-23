package LeetCode_JAVA;

public class ToHex {
    public String toHex(int x) {
        StringBuffer result = new StringBuffer();
        char[] dict = "0123456789abcdef".toCharArray();
        while (x != 0) {
            int fourBits = x & 15; // 提取x的前四位
            x >>>= 4; // x右移四位，处理第二个四位
//            String hexNumber = fourBits > 9 ? (char)(fourBits - 10 + 'A') + "" : fourBits + "";
            char hexNumber = dict[fourBits];
            result.insert(0, hexNumber);
        }
        return new String(result);
    }
}
