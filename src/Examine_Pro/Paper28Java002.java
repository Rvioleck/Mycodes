package Examine_Pro;

public class Paper28Java002 {
    public static void main(String args[]){
        int i=0;
        String greetings[] ={ "Hello World!","Hello!","HELLO WORLD!!"};
        while (i<4){
            try{
                //*********Found********
                System.out.println(greetings[i]); // greetings
            }
            //*********Found********
            catch (ArrayIndexOutOfBoundsException e){ // catch
                //*********Found********
                System.out.println("Catch " + e.getMessage()); // e
                System.out.println("Ending the print.");
            }
         finally{
                System.out.println("---------------------");
            }
            //*********Found********
            i++; // i++
        }
    }
}
