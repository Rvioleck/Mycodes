package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;
import java.util.Random;

public class KClosest3 {

    public int[][] kClosest(int[][] points, int K) {
        return quickSort(points, 0, points.length - 1, K);
    }

    private int[][] quickSort(int[][] points, int left, int right, int k) {
        int pivotIdx = partition(points, left, right);
        if (pivotIdx == k - 1) {
            return Arrays.copyOf(points, k);
        }
        return pivotIdx > k - 1 ?
                quickSort(points, left, pivotIdx - 1, k) :
                quickSort(points, pivotIdx + 1, right, k);

    }

    private int partition(int[][] points, int left, int right) {
        int rand = new Random().nextInt(right - left + 1) + left;
        int[] temp = points[rand];
        points[rand] = points[left];
        points[left] = temp;
        int[] pivotPoint = points[left];
        int pivot = getDistance(points[left]);
        while (left < right) {
            while (left < right && getDistance(points[right]) >= pivot) {
                right--;
            }
            points[left] = points[right];
            while (left < right && getDistance(points[left]) <= pivot) {
                left++;
            }
            points[right] = points[left];
        }
        points[left] = pivotPoint;
        return left;
    }

    private int getDistance(int[] point) {
        return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

    public static void main(String[] args) {
        int[][] res = new KClosest3().kClosest(new int[][]{
                {1, 2},
                {2, 0},
                {-2, 2},
                {3, 1},
                {4, 0},
                {1, -1}
        }, 3);
        for (int[] one :
                res) {
            System.out.println(Arrays.toString(one));
        }
    }

}
