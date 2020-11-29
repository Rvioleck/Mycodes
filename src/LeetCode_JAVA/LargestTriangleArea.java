package LeetCode_JAVA;

import org.junit.Test;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                for (int k = j+1; k < points.length; k++) {
                    double now = getArea(points[i], points[j], points[k]);
                    if (now > max){
                        max = now;
                    }
                }
            }
        }
        return max;
    }

    public double getArea(int[] point1, int[] point2, int[] point3){
        double result = point1[0]*point2[1] - point1[0]*point3[1]
                      + point2[0]*point3[1] - point2[0]*point1[1]
                      + point3[0]*point1[1] - point3[0]*point2[1];
        return Math.abs(result/2);
    }


    @Test
    public void test(){
        int[][] points = {{0,0}, {1,0}, {0,1}, {0,2}, {2,0}};
        System.out.println(largestTriangleArea(points));
    }
}
