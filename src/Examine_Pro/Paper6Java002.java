package Examine_Pro;

import java.io.RandomAccessFile;

public class Paper6Java002 {
    public static void main(String args[]) throws Exception{
        long filePoint = 0 ;
        String s;
        RandomAccessFile file = new RandomAccessFile("file1.txt","r");
        long fileLength = file.length();
        while (filePoint<fileLength){
            s = file.readLine();
            System.out.println(s);
            //*********Found********
            filePoint = file.getFilePointer(); //file
        }
        //*********Found********
        file.close(); // close()
    }
}
