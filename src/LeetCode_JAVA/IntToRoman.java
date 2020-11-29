package LeetCode_JAVA;

import org.junit.Test;

import java.util.HashMap;

public class IntToRoman {
    public String intToRoman(int num){
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put(1, "I");
//        map.put(4, "IV");
//        map.put(5, "V");
//        map.put(9, "IX");
//        map.put(10, "X");
//        map.put(40, "XL");
//        map.put(50, "L");
//        map.put(90, "XC");
//        map.put(100, "C");
//        map.put(400, "CD");
//        map.put(500, "D");
//        map.put(900, "CM");
//        map.put(1000, "M");
        int[] key = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] value = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder result = new StringBuilder();
        for (int i = key.length - 1; i >= 0 ; i--) {
            while (num >= key[i]){
                num -= key[i];
                result.append(value[i]);
            }
        }
        return new String(result);
    }

    @Test
    public void test(){
        int x = 58;
        System.out.println(intToRoman(x));
    }
}
