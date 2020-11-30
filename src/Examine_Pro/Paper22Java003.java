package Examine_Pro;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class Paper22Java003 {
    public static void main(String[] args)
    {
        FontFrame frame = new FontFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

//*********Found********
class FontFrame extends JFrame // extends
{
    public FontFrame()
    {
        setTitle("沁园春.雪");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        FontPanel panel = new FontPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);
    }
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

//*********Found********
class FontPanel extends JPanel // JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        String message = "数风流人物，还看今朝！";
        Font f = new Font("隶书", Font.BOLD, 24);
        g2.setFont(f);
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        g2.setPaint(Color.RED);
        //*********Found********
        g2.drawString(message, (int)x, (int)(baseY)); // String
    }
}
