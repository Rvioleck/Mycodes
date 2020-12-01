package Examine_Pro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Paper28Java003 {
    public static void main(String[] args)
    {
        Paper28Java003 exceptionExample = new Paper28Java003();
        //*********Found**********
        try // try
        {
            FileInputStream fi = new FileInputStream("C:" + "\\" + "abc.txt");
        }
        //*********Found**********
        catch(FileNotFoundException ex) // catch
        {
            //*********Found**********
            System.out.println(ex.getMessage()+   // ex
                    "请确认文件路径及文件名是否正确！");
        }
    }
}
