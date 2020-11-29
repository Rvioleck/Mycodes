package Examine_Pro;

public class Paper6Java003 {
    public static void main(String[] args) {
        String text = "Beijing, the Capital City, is the political,"
                + "cultural and diplomatic centre of China. It has"
                + "become a modern international cosmopolitan city"
                + "with more than 11 million people. The Capital"
                + "International Airport, 23.5 km from the city centre,"
                + "is China's largest and most advanced airport.";
        int vowels  = 0 ;
        //*********Found*********
        int textLength = text.length(); // textLength
        for(int i = 0; i < textLength; i++) {
            //*********Found*********
            char ch = Character.toLowerCase(text.charAt(i)); // charAt(i)
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                //*********Found*********
                vowels++; // vowels++;
            }
        }
        System.out.println("The text contained vowels: " + vowels + "\n" );
    }
}
