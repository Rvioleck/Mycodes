package Examine_Pro;

import java.io.*;

public class Paper11Java001 {
    public static void main(String[] args) {
        char[] charArray = {'a','b','c','d','e','f','g','h','i'};
        char c  ;
        try{
//*********Found**********
            DataOutputStream out = new DataOutputStream(
                    new FileOutputStream("test.dat"));
            for(int i =0; i<charArray.length; i++){
                out.writeChar(charArray[i]);
            }
            out.close();
            DataInputStream in = new DataInputStream(
//*********Found**********
                    new FileInputStream("test.dat"));
            while(in.available() != 0){
                c=in.readChar();
                System.out.print(c+" ");
            }
            System.out.println();
//*********Found**********
            in.close(); // close
        }catch(IOException e){}
    }
}


