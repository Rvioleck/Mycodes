package Examine_Pro;

import java.io.*;

public class Paper17Java002 {
    public static void main(String[] args)
    {
        int[] intArray = {1,2,3,4,5};
        int j  ;

        try
        {
            DataOutputStream out = new DataOutputStream(
                    new FileOutputStream("data.dat"));
            for(j =0; j<intArray.length; j++)
            {
                //*********Found********
                out.writeInt(intArray[j]); // writeInt
            }
            out.close();

            DataInputStream in = new DataInputStream(
                    //*********Found********
                    new FileInputStream("data.dat")); // FileInputStream
            while(in.available() != 0)
            {
                j = in.readInt();
                System.out.println(j);
            }
            in.close();
        }
        catch(IOException e){}
    }
}
