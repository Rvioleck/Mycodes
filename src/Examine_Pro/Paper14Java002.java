package Examine_Pro;

public class Paper14Java002 {
    public static void main(String[] args) {
        int[] arrayOfInts = { 32, 87, 3, 589, 12, 1076, 2000, 8, 622, 127 };
        int searchfor = 12;
        int i = 0;
        boolean foundIt = false;
        //*********Found********
        for ( ; i < arrayOfInts.length; i++) { // arrayOfInts.length
            if (arrayOfInts[i] == searchfor) {
                //*********Found********
                foundIt = true; // true
                break;
            }
        }
        if (foundIt) {
            System.out.println("Found " + searchfor + " at index " + i);
        }
        else {
            System.out.println(searchfor + "not in the array");
        }
    }
}
