package Examine_Pro;

//程序的功能是从1开始，每秒打印一个递增的整数。
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Paper5Java003{
    public static void main(String[] args){
        ActionListener listener = new TimePrinter();
        //*********Found********
        Timer t = new Timer(1000, listener); // listener
        t.start();
        JOptionPane.showMessageDialog(null, "退出程序?");
        System.exit(0);
    }
}

//*********Found********
class TimePrinter implements ActionListener{ // ActionListener
    //*********Found********
    public void actionPerformed(ActionEvent event){ // Performed
        i++;
        System.out.println(i);
        Toolkit.getDefaultToolkit().beep();
    }
    int i = 0;
}


