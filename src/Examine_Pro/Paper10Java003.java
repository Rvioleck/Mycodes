package Examine_Pro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//*********Found**********
public class Paper10Java003 extends JApplet implements ActionListener{ // ActionListener
    JLabel prompt;
    JTextField input;
    public void init(){
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        //*********Found**********
        prompt = new JLabel( "输入球半径: " ); // JLabel
        input = new JTextField( 10 );
        //*********Found**********
        input.addActionListener(this); // input.addActionListener(this)
        c.add( prompt );
        c.add( input );
    }
    public void actionPerformed( ActionEvent e ){
        double radius =
                Double.parseDouble( e.getActionCommand() );
        showStatus( "体积 " + sphereVolume( radius ) );
    }
    public double sphereVolume( double radius ){
        double volume =
                ( 4.0 / 3.0 ) * Math.PI * Math.pow( radius, 3 );
        return volume;
    }
}

