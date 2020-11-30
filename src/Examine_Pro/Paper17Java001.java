package Examine_Pro;

public class Paper17Java001 {
    public static void main(String args[])
    {
        //*********Found********
        char a='q'; // char
        byte   b1=8;
        int    i=200;
        long   b=678L;
        //*********Found********
        float f=98.99f; // float
        double d=4.7788;
        int    aa=a+i;
        long   bb=b-aa;
        float  ff=b1*f;
        double dd=ff/aa+d;

        System.out.println("aa="+aa);
        System.out.println("bb="+bb);
        System.out.println("ff="+ff);
        System.out.println("dd="+dd);
    }
}
