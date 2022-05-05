package DataStructure_zcy;

public class KMP {

    public static int kmp(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0, i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                // str1[i1] != str2[i2] && i2 == 0
                i1++;
            } else { // i2 > 0
                i2 = next[i2];
            }
        }
        // i1越界或i2越界
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms){
        if (ms.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;  // next数组遍历的指针
        int cn = 0; // i-1位置的最长前后缀的长度
        while (i < ms.length){
            if (ms[i - 1] == ms[cn]){
                // next[i++] = ++cn;
                next[i] = cn + 1;
                i++;
                cn++;
            } else if (cn > 0){
                cn = next[cn];
            } else {
                // next[i++] = 0;
                next[i] = 0;
                i++;
            }
        }
        return next;
    }

}
