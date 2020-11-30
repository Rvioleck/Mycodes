package Examine_Pro;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.text.*;

//*********Found********
public class Paper23Java003 extends JFrame implements ActionListener { // JFrame
    private JTextField input1, input2, output;
    private int number1, number2;
    private double result;

    // 初始化
    public Paper23Java003()
    {
        //*********Found********
        super( "示范异常" ); // super

        Container c = getContentPane();
        c.setLayout( new GridLayout( 3, 2 ) );

        c.add( new JLabel( "输入分子",
                SwingConstants.RIGHT ) );
        input1 = new JTextField( 10 );
        c.add( input1 );

        c.add(
                new JLabel( "输入分母和回车",
                        SwingConstants.RIGHT ) );
        input2 = new JTextField( 10 );
        c.add( input2 );
        input2.addActionListener( this );

        c.add( new JLabel( "计算结果", SwingConstants.RIGHT ) );
        output = new JTextField();
        c.add( output );

        setSize( 425, 100 );
        show();
    }

    //处理 GUI 事件
    public void actionPerformed( ActionEvent e )
    {
        DecimalFormat precision3 = new DecimalFormat( "0.000" );

        output.setText( "" ); // 空的JTextField输出

        try {
            number1 = Integer.parseInt( input1.getText() );
            number2 = Integer.parseInt( input2.getText() );

            result = quotient( number1, number2 );
            //*********Found********
            output.setText(precision3.format(result)); //  output.setText(precision3.format(result))
        }
        catch ( NumberFormatException nfe ) {
            //*********Found********
            JOptionPane.showMessageDialog( this, // JOptionPane.showMessageDialog
                    "你必须输入两个整数",
                    "非法数字格式",
                    JOptionPane.ERROR_MESSAGE );
        }
        catch ( Exception dbze ) {
            //*********Found********
            JOptionPane.showMessageDialog( this, // JOptionPane.showMessageDialog
                    "除法异常",
                    "除数为零",
                    JOptionPane.ERROR_MESSAGE );
        }
    }

    // 定义求商的方法，如遇除数为零时，能抛出异常。
    public double quotient( int numerator, int denominator )
            throws Exception
    {
        if ( denominator == 0 )
            throw new Exception();

        return ( double ) numerator / denominator;
    }

    public static void main( String args[] )
    {
        Paper23Java003 app = new Paper23Java003();

        app.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing( WindowEvent e )
                    {
                        e.getWindow().dispose();
                        System.exit( 0 );
                    }
                }
        );
    }
}


