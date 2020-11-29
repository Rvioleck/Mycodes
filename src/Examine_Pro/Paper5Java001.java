package Examine_Pro;

public class Paper5Java001 {
    public static void main(String[] args) {
        //*********Found**********
        for (int i=1;i<=5;i++){ // i<=5
            for(int k=1;k<=5-i;k++)
                //*********Found**********
                System.out.print(" "); // System.out.print(" ")
            //*********Found**********
            for(int j=1;j<=2*i-1;j++) // int j=1
                System.out.print("*");
            //*********Found**********
            System.out.println(); // System.out.println()
        }
    }
}
