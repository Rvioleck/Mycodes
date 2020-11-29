package Examine_Pro;

import java.io.*;
import java.util.*;

public class Paper3Java003 {
    public static void main (String args[])
            throws IOException
    {
        FileOutputStream unbufStream = new FileOutputStream("test.one");
        BufferedOutputStream bufStream = new BufferedOutputStream(
                //*********Found**********
                new FileOutputStream ("test.two"));
        System.out.println();
        System.out.println("这是一个测试缓冲流和非缓冲流速度的程序。");
        System.out.println();
        int flag = time(unbufStream)-time(bufStream);
        if(flag > 0)
        {
            System.out.println("测试结果：缓冲流的传输速度快于非缓冲流。");
            System.out.println();
        }
        else
            System.out.println("测试结果：缓冲流的传输速度慢于非缓冲流。");
    }
    static int time (OutputStream out)
            throws IOException
    {
        Date then = new Date();
        for (int i=0; i<50000; i++)
        {
            //*********Found**********
            out.write (1);
        }
        //*********Found**********
        out.close ();
        return (int)((new Date()).getTime() - then.getTime());
    }
}
