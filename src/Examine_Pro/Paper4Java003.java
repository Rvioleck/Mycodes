//package Examine_Pro;
//
//import java.awt.*;
//import javax.swing.*;
//
public class Paper4Java003 {
//    int grades[][] = { { 77, 68, 86, 73 },
//            { 96, 87, 89, 81 },
//            { 70, 90, 86, 81 } };
//    int students, exams;
//    String output;
//    JTextArea outputArea;
//    //对实例变量初始化
//    public void init(){
//        students = grades.length;
//        exams = grades[ 0 ].length;
//        //*********Found**********
//        outputArea = new JTextArea(); //JTextArea()
//        Container c = getContentPane();
//        c.add( outputArea );
//        //输出
//        output = "数组是:";
//        buildString();
//        output += "\n\n最低分: " + minimum() +
//                "\n最高分: " + maximum() + "\n";
//        for ( int i = 0; i < students; i++ )
//            output += "\n学生的平均分" + i + " 组是 " +
//                    average( grades[ i ] );
//        outputArea.setFont(
//                new Font( "Courier", Font.PLAIN, 12 ) );
//        outputArea.setText( output );
//    }
//    //找最底分
//    public int minimum(){
//        int lowGrade = 100;
//        for ( int i = 0; i < students; i++ )
//            for ( int j = 0; j < exams; j++ )
//                if ( grades[ i ][ j ] < lowGrade )
//                    lowGrade = grades[ i ][ j ];
//        //*********Found**********
//        return lowGrade; // lowGrade
//    }
//    //找最高分
//    public int maximum(){
//        int highGrade = 0;
//        for ( int i = 0; i < students; i++ )
//            for ( int j = 0; j < exams; j++ )
//                if ( grades[ i ][ j ] > highGrade )
//                    highGrade = grades[ i ][ j ];
//        return highGrade;
//    }
//    //对各组学生确定平均分
//    public double average( int setOfGrades[] ){
//        int total = 0;
//        for ( int i = 0; i < setOfGrades.length; i++ )
//            total += setOfGrades[ i ];
//        //*********Found**********
//        return ( double ) total / setOfGrades.length; // setOfGrades.length
//    }
//    //输出格式
//    public void buildString(){
//        output += "           ";
//        for ( int i = 0; i < exams; i++ )
//            output += "[" + i + "]  ";
//        for ( int i = 0; i < students; i++ ) {
//            output += "\ngrades[" + i + "]   ";
//            for ( int j = 0; j < exams; j++ )
//                output += grades[ i ][ j ] + "   ";
//        }
//    }
}
