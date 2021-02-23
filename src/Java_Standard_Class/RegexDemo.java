package Java_Standard_Class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        // String类的matches(),split(),replaceFirst(),replaceAll()的方法均需要传入一个正则表达式
//		String regex = "[，。 ]+";
//		String s = "中国，你好。Java。。 程序设计。";
//		String[] ss = s.split(regex);
//		for(String a:ss){
//			System.out.println(a);
//		}
//		Pattern p = null;
//		Matcher m = null;
//		boolean b = false;
//		p = Pattern.compile("^[1][3-5]+\\d{9}");
//		String[] numbers = {"13996332243", "1227788", "15676789065", "139abcd1234"};
//		for(String s:numbers){
//			m = p.matcher(s);
//			b = m.matches();
//			System.out.print("手机号码正确：" + b);
//		}
        /* 使用正则表达式检测IP地址 */
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}");
        String[] ips = {"192.168.1.1", "192.168.1.1345", "222.168.1.134", "322.168.1.134"};
        for (String ip : ips) {
            m = p.matcher(ip);
            b = m.matches();
            System.out.println(ip + ": " + b);
        }
    }
}
