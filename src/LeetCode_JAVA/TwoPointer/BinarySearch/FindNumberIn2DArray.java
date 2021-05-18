package LeetCode_JAVA.TwoPointer.BinarySearch;

public class FindNumberIn2DArray {

    public static void main(String[] args) {
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        },5));
    }

    public boolean find(int[][] matrix, int x, int y, int target, int m, int n){
        if (x >= m || y >= n){
            return false;
        }
        if (matrix[x][y] == target){
            return true;
        }
        int l = x, r = m - 1;
        while (l <= r){
            int mid = l - (l - r) / 2;
            if (matrix[mid][y] < target){
                l = mid + 1;
            } else if (matrix[mid][y] > target){
                r = mid - 1;
            } else {
                return true;
            }
        }
        l = y;
        r = n - 1;
        while (l <= r){
            int mid = l - (l - r) / 2;
            if (matrix[x][mid] < target){
                l = mid + 1;
            } else if (matrix[x][mid] > target){
                r = mid - 1;
            } else {
                return true;
            }
        }
        return find(matrix, x + 1, y + 1, target, m, n);
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return find(matrix, 0, 0, target, matrix.length, matrix[0].length);
    }
}
