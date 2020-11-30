package Examine_Pro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paper16Java003 {
    public static void main(String[] args){
        ButtonFrame frame = new ButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();
    }
}

//*********Found********
class ButtonFrame extends JFrame{ // ButtonFrame
    public ButtonFrame(){
        setTitle("测试按钮");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ButtonPanel panel = new ButtonPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);
    }
    public static final int DEFAULT_WIDTH = 200;
    public static final int DEFAULT_HEIGHT = 100;
}

class ButtonPanel extends JPanel {
    public ButtonPanel(){
        JButton yellowButton = new JButton("黄色");
        add(yellowButton);
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        yellowButton.addActionListener(yellowAction);
    }
    //*********Found********
    private class ColorAction implements ActionListener{ // ActionListener
        public ColorAction(Color c){
            backgroundColor = c;
        }
        //*********Found********
        public void actionPerformed(ActionEvent event){ // actionPerformed
            setBackground(backgroundColor);
        }
        private Color backgroundColor;
    }
}
