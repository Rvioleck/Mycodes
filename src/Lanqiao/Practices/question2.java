package Lanqiao.Practices;

import java.util.HashMap;
import java.util.Scanner;

public class question2 {

    public int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int len = chars.length;
        int result = map.get(chars[len - 1]);
        for (int i = len - 2; i >= 0 ; i--) {
            if (map.get(chars[i]) < map.get(chars[i + 1])){
                result -= map.get(chars[i]);
            }
            else
                result += map.get(chars[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        question2 obj = new question2();
        Scanner sc = new Scanner(System.in);
        String roman = sc.nextLine();
        System.out.println(obj.romanToInt(roman));
    }
}
