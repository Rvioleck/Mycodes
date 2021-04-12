package LeetCode_JAVA.String;

import java.util.Arrays;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        // lambda表达式重写Arrays.sort
        Arrays.sort(logs, (o1, o2) -> {
            String[] s1 = o1.split(" ", 2), s2 = o2.split(" ", 2);
            // 分离原log, id为标识符, text为文本内容
            String id1 = s1[0], text1 = s1[1], id2 = s2[0], text2 = s2[1];
            // sign提取日志首字母用于后续判断其为字母日志还是数字日志
            char sign1 = text1.charAt(0), sign2 = text2.charAt(0);
            // 若一者为字母日志，一者为数字日志，则数字日志返回1
            if (Character.isDigit(sign1) && Character.isLetter(sign2)) {
                return 1;
            } else if (Character.isLetter(sign1) && Character.isDigit(sign2)) {
                return -1;
            } else if (Character.isLetter(sign1) && Character.isLetter(sign2)) {
                // 若均为字母日志，先比较文本，后比较标识符
                int textCompare = text1.compareTo(text2);
                if (textCompare != 0) {
                    return textCompare;
                } else {
                    return id1.compareTo(id2);
                }
            }
            // 若均为数字日志，则按正常顺序返回
            return 0;
        });
        return logs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReorderLogFiles().reorderLogFiles(new String[]{
                "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
        })));
    }

}
