package Lanqiao.Provincial10th;

import java.util.ArrayList;
import java.util.List;

public class B_DifferSubString_Java {

    private int count = 0;
    private final List<String> subStrings = new ArrayList<>();

    private int differSubString(String s){
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String sub = s.substring(i, j + 1);
                if (!subStrings.contains(sub)){
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
