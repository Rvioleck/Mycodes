package Examine_Pro;

public class Paper21Java001 {
    public static void main(String args[])
    {
        int a,b,c,m;

        a = 15;
        b = 5;
        c = 25;

        //*********Found**********
        m = a; // m = a;

        if ( m > b )
            //*********Found**********
            m = b;
        if ( m > c )
            //*********Found**********
            m = c;

        System.out.println(" min = " + m);

    }
}
