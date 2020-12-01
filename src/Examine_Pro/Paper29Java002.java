package Examine_Pro;

public class Paper29Java002 {
    public static void main(String args[]){
        int i=0;
        //*********Found********
        String greetings[]={ "Hello World!","Hello!","HELLO WORLD!!"}; // String
        while (i<4){
            //*********Found********
            try{ // try
                System.out.println(greetings[i]);
            }
         catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Ending the print.");
            }
         finally{
                System.out.println("---------------------");
            }
            i++;
        }
    }
}
