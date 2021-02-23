package LeetCode_JAVA;

import org.junit.Test;

public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        while (n-- != 1) {
            res = apperance(res);
        }
        return new String(res);
    }

    public StringBuilder apperance(StringBuilder last) {
//        if (last.length() == 1){
//            return new StringBuilder().append("1").append(last);
//        }
        StringBuilder result = new StringBuilder();
        int count = 1, i;
        for (i = 0; i <= last.length() - 2; i++) {
            if (last.charAt(i) != last.charAt(i + 1)) {
                result = result.append(count).append(last.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        result = result.append(count).append(last.charAt(i));
        return result;
    }

    @Test
    public void test() {
        StringBuilder last = new StringBuilder("1");

        System.out.println(countAndSay(1));
//        System.out.println(apperance(last));
    }
}
