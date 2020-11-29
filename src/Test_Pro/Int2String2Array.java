package Test_Pro;

import org.junit.Test;
import java.util.Arrays;

public class Int2String2Array {

    public void stringTobasic(String str){
        int i = Integer.parseInt(str);
        byte b = Byte.parseByte(str);
        double d = Double.parseDouble(str);
    }


    public String basicTostring(){
        int i = 10;
        byte b = 2;
        double d = 2.3;
        String str1 = String.valueOf(i);
        String str2 = String.valueOf(b);
        String str3 = String.valueOf(d);
        return str1;
    }


    public String basicArrayTostring(){
        int[] arrInt = {1, 3, 56, 2};
        String str1 = Arrays.toString(arrInt);
        System.out.println(str1);

        char[] arrChar = {'中', 'c', '2', 'd'};
        String str2 = Arrays.toString(arrChar);
        str2 = new String(arrChar); // char[] 和 byte[] 可以初始化为String
        System.out.println(str2);

        byte[] arrByte = {2, 3, 5, 12, 34};
        String str3 = Arrays.toString(arrByte);
        str3 = new String(arrByte);
        System.out.println(str3);

        return str3;
    }


    public void arrayChar_string(){
        String str = "123";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
        String str1 = new String(charArray);
        System.out.println(str1);
    }


    public void arrayByte_string(){
        String str = "123abc中国";
        byte[] b = str.getBytes();
        String str2 = Arrays.toString(b);
    }



    public static void main(String[] args) {
        Int2String2Array obj = new Int2String2Array();
        obj.basicArrayTostring();
    }
}
