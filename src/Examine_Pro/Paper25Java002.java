package Examine_Pro;

public class Paper25Java002 {
    public static void main(String[ ] args) {
        //*********Found**********
        Point[] pt = new Point[2]; // Point[]
        pt[0] = new Point();
        pt[1] = new Point(2, 3);
        //*********Found**********
        for (int i=0; i < pt.length; i++) { // length
            System.out.print( pt[i] );
        }
    }
}

class Point {

    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    //*********Found**********
    public Point (int a, int b) { // Point
        x = a;
        y = b;
    }

    int getX( ) {
        return x;
    }

    int getY( ) {
        //*********Found**********
        return y; // y
    }

    void setX(int a) {
        x = a;
    }

    void setY(int b) {
        y = b;
    }

    public String toString ( ) {
        return "  ( " + x + "," + y + " ) ";
    }
}
