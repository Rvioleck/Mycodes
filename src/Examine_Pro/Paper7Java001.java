package Examine_Pro;

public class Paper7Java001 {
    public static void main(String args[]) {
        int x = 1;
        String [] names = { "张民", "王托", "强强" };
        for (int i = 0; i < names.length; i++) {
            //*********Found**********
            names[i] = names[i] + "？"; // + "？"
            System.out.println(names[i]);
        }
    }
}
