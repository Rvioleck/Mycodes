package Examine_Pro;

public class Paper30Java002 {
    public static void main(String[] args)
    {
        int[] anArray;	          // 声明一个整型数组
        //*********Found********
        anArray = new int[10];    // 创建数组,包含10个元素。 new int[10]

        // 给数组每个元素赋值并打印输出
        for (int i = 0; i < anArray.length; i++)
        {
            //*********Found********
            anArray[i]=i; // anArray[i]
            System.out.print(anArray[i] + " ");
        }
        System.out.println();
    }
}
