package Examine_Pro;

public class Paper2Java001 {
    public static void main(String[] args) {
        int i,count;

        //*********Found********
        count = 0; // count = 0

        for( i=100 ; i <= 200 ; i++)
            //*********Found********
            if ( i % 3 == 0 ) count++; // i % 3 == 0

        //*********Found********
        System.out.println("Count = " + count);
    }
}
