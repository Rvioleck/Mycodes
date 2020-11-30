package Examine_Pro;

public class Paper16Java001 {
    public static void main(String[] args) {
        int[] anArray;   //声明一个整数型数组
        anArray = new int[10];   //创建一个整数数组对象s
        //对数组中每个元素赋值并显示
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = i;
            //*********Found**********
            System.out.print(anArray[i]+ " "); // anArray[i]
        }
        System.out.println();
    }
}
