package Examine_Pro;

import java.io.*;

public class Paper23Java002 {
    public static void main(String[] args) throws IOException
    {
        File inputFile;
        File outputFile;
        FileInputStream in;
        FileOutputStream out;
        int c;

        inputFile = new File("source.txt");
        outputFile = new File("dest.txt");
        in = new FileInputStream(inputFile);
        //*********Found********
        out = new FileOutputStream(outputFile); // out = new FileOutputStream

        while ((c = in.read()) != -1)
            //*********Found********
            out.write(c); // out.write(c)

        in.close();
        out.close();
    }
}
