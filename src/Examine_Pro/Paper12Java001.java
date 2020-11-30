package Examine_Pro;

import javax.swing.*;

public class Paper12Java001 {
    public static void main( String args[] ){
        String output = "";
        //标注复合语句
        stop: {
            for ( int row = 1; row <= 10; row++ ) {
                for ( int column = 1; column <= 5 ; column++ ) {
                    if ( row == 5 )
                        //*********Found********
                        break stop; // stop
                    output += "*  ";
                }
                output += "\n";
            }
            //跳过下一行
            output += "\n循环正常终止";
        }
        JOptionPane.showMessageDialog(
                //*********Found********
                null, output,"用标记的break语句测试成功!",
                JOptionPane.INFORMATION_MESSAGE );
        System.exit( 0 );
    }
}
