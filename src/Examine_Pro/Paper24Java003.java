package Examine_Pro;

//BubbleSort.java
//对数组中的值按递增次序排序

import java.awt.*;
import javax.swing.*;

public class Paper24Java003 extends JApplet {
    public void init(){
        JTextArea outputArea = new JTextArea();
//*********Found**********
        Container c = getContentPane(); // getContentPane();
        c.add( outputArea );
        int a[] = { 2, 6, 4, 8, 10, 12, 89, 68, 45, 37 };
        String output = "数据项原来次序是:\n";
        for ( int i = 0; i < a.length; i++ )
            output += "   " + a[ i ];
        bubbleSort( a );
        output += "\n\n数据项经递增次序是:\n";
        for ( int i = 0; i < a.length; i++ )
            output += "   " + a[ i ];
//*********Found**********
        outputArea.append( output ); // append
    }
    //数组元素用"冒泡"排序方法排序
    public void bubbleSort( int b[] ){
//*********Found**********
        for ( int pass = 1; pass < b.length; pass++ ) // b.length
            for ( int i = 0; i < b.length - 1; i++ )
                if ( b[ i ] > b[ i + 1 ] )        //比较
                    swap( b, i, i + 1 );           //交换
    }
    //数组的两个元素交换方法
    public void swap( int c[], int first, int second ){
        int hold;  //为交换暂时保存
        hold = c[ first ];
        c[ first ] = c[ second ];
        c[ second ] = hold;
    }
}

