package Examine_Pro;

import java.io.RandomAccessFile;

public class Paper12Java002 {
    //*********Found********
    public static void main(String args[]) throws Exception{ // throws
        long filePoint = 0 ;
        String s;
        RandomAccessFile file = new RandomAccessFile("Java_2.java","r");
        long fileLength = file.length();
        while (filePoint<fileLength){
            //*********Found********
            s = file.readLine(); // file
            System.out.println(s);
            filePoint = file.getFilePointer();
        }
        file.close();
    }
}
