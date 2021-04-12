package LeetCode_JAVA.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSortString {

    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        int lenT = T.length();
        List<Character> list1 = new ArrayList<>();
        for (int i = 0; i < lenT; i++) {
            list1.add(T.charAt(i));
        }
        list1.sort((x, y) -> {
            boolean xInS = map.containsKey(x), yInS = map.containsKey(y);
            if (!xInS && !yInS) {
                return 0;
            } else if (!xInS) {
                return 1;
            } else if (!yInS) {
                return -1;
            } else {
                int priorX = map.get(x), priorY = map.get(y);
                return priorX - priorY;
            }
        });
        StringBuilder res = new StringBuilder();
        for (Character ch :
                list1) {
            res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("exv", "xwvee"));
    }
}
