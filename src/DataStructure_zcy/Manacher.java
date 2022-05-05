package DataStructure_zcy;

public class Manacher {

    public char[] manacherString(String str){
        char[] chars = str.toCharArray();
        char[] res = new char[chars.length * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; ++i){
            res[i] = ((i & 1) == 0) ? '#' : chars[index++];
        }
        return res;
    }

    public int maxLcpsLength(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] str = manacherString(s); // 1221 -> #1#2#2#1#
        int[] pArr = new int[str.length]; // 记录每个位置的回文半径
        int C = -1;  // 最大回文半径的中心
        int R = -1;  // 最大回文半径的右边界的右位置
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; ++i){
            // i的至少回文半径
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1){
                if (str[i + pArr[i]] == str[i - pArr[i]]){
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
    }

}
