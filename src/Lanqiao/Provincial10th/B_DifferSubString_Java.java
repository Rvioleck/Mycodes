package Lanqiao.Provincial10th;

import java.util.ArrayList;
import java.util.List;

public class B_DifferSubString_Java {

    private int count = 0; // 记录子串数目
    private final List<String> subStrings = new ArrayList<>(); // 记录所有子串

    /**
     * @param s 给定子串s判断其有多少个不同空字串
     * @return 不同非空子串的个数
     */
    private int differSubString(String s){
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String sub = s.substring(i, j + 1); // substring方法获得下标为[i, j]区间的子串
                if (!subStrings.contains(sub)){     // 子串sub不在集合中就将其加入集合中
                    count++;
                    subStrings.add(sub);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "0100110001010001";
        System.out.println(new B_DifferSubString_Java().differSubString(s));
    }
}
