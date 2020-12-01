package Examine_Pro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//*********Found********
public class Paper27Java003 implements ActionListener { // implements
    public static void main(String args[ ])
    {
        Paper27Java003 tb = new Paper27Java003();
        Frame f = new Frame("Button Test");
        f.setSize(200,100);
        f.setLayout(new FlowLayout(FlowLayout.CENTER));

        Button b = new Button("Press the Button!");
        //*********Found********
        b.addActionListener(tb); // addActionListener

        f.add(b);
        f.setVisible(true) ;
    }

    public void actionPerformed(ActionEvent e)
    {
        Frame fr = new Frame("An Other");
        fr.setBackground(Color.green);
        fr.add(new Label("This frame shows when "+"pressing the button in Button Test"));
        fr.pack();
        fr.setVisible(true) ;
    }
}
