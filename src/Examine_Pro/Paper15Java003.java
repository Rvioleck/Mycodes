package Examine_Pro;
//Java_3.java:二分法检索算法
import java.util.*;

public class Paper15Java003 {
    private String colors[] = { "红", "白", "蓝",
            "黑", "黄",
            "紫", "茶色", "粉红" };
    private ArrayList aList; // ArrayList 引用
    public Paper15Java003(){
        aList = new ArrayList( Arrays.asList( colors ) );
        Collections.sort( aList );   //ArrayList分类
        System.out.println( "对ArrayList分类: " + aList );
    }

    public void printSearchResults(){
        printSearchResultsHelper( colors[ 3 ] ); //首项
        printSearchResultsHelper( colors[ 0 ] ); //中间项
        printSearchResultsHelper( colors[ 7 ] ); //最后项
        printSearchResultsHelper( "绿" );        //最低
        printSearchResultsHelper( "灰" );        //不存在
        //*********Found********
        printSearchResultsHelper( "橙色" );      //不存在 // 橙色
    }

    private void printSearchResultsHelper( String key ){
        int result = 0;
        System.out.println( "\n检索关键字: " + key );
        result = Collections.binarySearch( aList, key );
        System.out.println( ( result >= 0 ? "找到下标"
                + result
                : "没有找到 (" + result + ")" ) );
    }

    public static void main( String args[] ){
        //*********Found********
        new Paper15Java003().printSearchResults(); //printSearchResults()
    }
}
