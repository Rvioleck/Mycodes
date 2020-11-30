package Examine_Pro;

import java.io.*;

public class Paper7Java002 {
    public static void main(String[] args)
    {
        char[] charArray = {'a','b','c','d','e','f'};
        char c;
        try
        {
            //*********Found********
            DataOutputStream out = new DataOutputStream(new FileOutputStream("test.dat")); // new FileOutputStream
            for(int i =0; i<charArray.length; i++)
            {
                out.writeChar(charArray[i]);
            }
            out.close();
            DataInputStream in = new DataInputStream(new FileInputStream("test.dat"));
            while(in.available() != 0)
            {
                //*********Found********
                c = in.readChar(); // c = in.readChar()
                System.out.print(c+" ");
            }
            System.out.println();
            in.close();
        }
        catch(IOException e){}
    }
}
