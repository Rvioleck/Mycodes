package Examine_Pro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Paper19Java003 {
    public static void main(String args[])
    {
        if(args.length<2)
        {
            System.out.println("ERROR: need parameters.");
            System.out.println("-usage: java <classname> <file1> <file2>");
            System.exit(0);      //退出程序
        }
        //*********Found**********
        File f1=new File( "a.txt" ); // "a.txt"
        //*********Found**********
        File f2=new File( "b.txt" ); // "b.txt"

        try
        {
            FileReader fr=new FileReader(f1);
            FileWriter fw=new FileWriter(f2);
            int b;

            while((b=fr.read()) != -1)
                //*********Found**********
                fw.write( b );
            //*********Found**********
            fr.close();       //关闭流文件 // close
            //*********Found**********
            fw.close();      //关闭流文件 // close
            System.out.println("has done!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
