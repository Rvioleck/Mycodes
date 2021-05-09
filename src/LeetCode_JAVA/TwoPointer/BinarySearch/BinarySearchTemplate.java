package LeetCode_JAVA.TwoPointer.BinarySearch;

public class BinarySearchTemplate {

    public static void main(String[] args) {
        new BinarySearchTemplate().template1();
        new BinarySearchTemplate().template2();
    }

    public void template1(){
        long l = 0, r = 1000009;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
    }

    public void template2(){
        long l = 0, r = 1000009;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
    }

    public boolean check(long mid){
        // func(mid);
        return mid == 1;
    }
}
