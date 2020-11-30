package Examine_Pro;

import javax.swing.*;

public class Paper23Java001 {
    public static void main( String args[] )
    {
        String output = "";
        int count;
        //*********Found********
        for ( count = 1; count <= 10; count++){ // count++
            //*********Found********
            if ( count == 5 ) //  == 5
            break;  // 当count为5时跳出循环
            output += count + " ";
        }
        output += "\nBroke out of loop at count = " + count;
        JOptionPane.showMessageDialog( null, output );
        System.exit( 0 );
    }
}
