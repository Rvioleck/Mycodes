package Experiment;

import org.junit.Test;

public class String_examinaion {
    @Test
    public void test1() {
        String str = "www.google.com";
        int Onum = 0, Gnum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'o')
                Onum++;
            else if (str.charAt(i) == 'g')
                Gnum++;
        }
        System.out.println("the number of letter o is " + Onum);
        System.out.println("the number of letter g is " + Gnum);
        System.out.println(str.substring(4, 10));
    }

    @Test
    public void test2() {
        String str1 = new String("Hello java");
        String str2 = new String("Hello java");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }

    public void test3() {
        String str1 = "hello";
        StringBuffer str2 = new StringBuffer("hello");
        str1 += " java";
        str2.append(" java");
        System.out.println(str1);
        System.out.println(str2);
    }
}
