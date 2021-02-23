package Test_Pro;

import java.util.Arrays;

public class StringExercice1 {

    public String trimOverride(String ori) {
        // 重写trim算法
        if (ori.length() == 0) {
            return "";
        }
        if (ori == null) {
            return null;
        }
        char[] chars = ori.toCharArray();
        String res = "";
        int i = 0, j = 0;
        for (i = 0; i < chars.length && chars[i] == ' '; i++) ; // 前指针到非空格字符
        if (i == ori.length()) { // 若全是空格 返回空
            return "";
        }
        for (j = chars.length - 1; j < chars.length && chars[j] == ' '; j--) ; // 后指针到非空格字符
        for (int k = i; k <= j; k++) {
            res += chars[k];
        }
        return res;
    }

    public String flipCharacter(String ori, int startIndex, int endIndex) {
        // 翻转startIndex到endIndex间的字符
        if (ori.length() == 0) {
            return "";
        }
        if (ori == null) {
            return null;
        }
        char[] chars = ori.toCharArray();
        for (int i = startIndex; i <= (startIndex + endIndex) / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[startIndex + endIndex - i];
            chars[startIndex + endIndex - i] = temp;
        }
        return new String(chars);
    }

    public int containNumber(String str1, String str2) {
        // 计算str2在str1间出现的次数
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        if (str1 == null || str2 == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i >= 0 && i < str1.length(); i = str1.indexOf(str2, i)) {
            if (i < 0) {
                break; // 找不到时indexOf赋值i为负，此时退出
            }
            i++;
            count++;
        }
        return count;
    }

    public String conSubString(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        if (str1 == null || str2 == null) {
            return null;
        }
        String res = "";
        for (int begin = 0; begin < str2.length(); begin++) {
            for (int end = str2.length() - 1; end >= 0; end--) {
                if (begin < end) {
                    Boolean flag = str1.contains(str2.substring(begin, end + 1));
                    if (flag) {
                        if (res.length() < str2.substring(begin, end + 1).length())
                            res = str2.substring(begin, end + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public String sortString(String str1) {
        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    public static void main(String[] args) {
        StringExercice1 obj = new StringExercice1();

        String ori = "33   ";
        System.out.println(obj.trimOverride(ori));

        String ori2 = "12345678";
        System.out.println(obj.flipCharacter(ori2, 2, 2));

        String str1 = "abcwerthelloyulodef";
        String str2 = "cvhellobnm";
        System.out.println(obj.containNumber(str1, str2));
        System.out.println(obj.conSubString(str1, str2));
        System.out.println(obj.sortString(str1));
    }

}
