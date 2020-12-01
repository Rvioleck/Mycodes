package Examine_Pro;

import java.awt.Graphics;
import javax.swing.JApplet;

public class Paper26Java003 extends JApplet {
    //*********Found**********
    public void paint(Graphics g){ // Graphic g
        int counter = 1;
        do {
//*********Found**********
            g.drawOval( 110 - counter * 10, 110 - counter * 10, // drawOval
                    counter * 20, counter * 20 );
//*********Found**********
            counter++; // 自增 // counter
        } while (counter<=10);
    }
}
