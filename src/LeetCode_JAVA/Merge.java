package LeetCode_JAVA;

import org.junit.Test;

import java.util.Arrays;
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }
        if (m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int maxLen = nums1.length;
        int j1 = m - 1, j2 = n - 1;
        for (int i = maxLen - 1; i >= 0 ; i--) {
            if (j2 == -1){
                nums1[i] = nums1[j1];
                j1--;
            }
            else if (j1 == -1){
                nums1[i] = nums2[j2];
                j2--;
            }
            else if (nums1[j1] < nums2[j2]){
                nums1[i] = nums2[j2];
                j2--;
            }
            else if (nums1[j1] >= nums2[j2]){
                nums1[i] = nums1[j1];
                j1--;
            }
        }
    }

    @Test
    public void test(){
        int[] nums1 = {4,4,5,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1, 3, nums2, 3);
        for (int num:nums1
             ) {
            System.out.println(num+" ");
        }
    }


//    public static void main(String[] args) {
//        Merge m = new Merge();
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 7};
//        m.merge(nums1, 6, nums2, 3);
//    }

}
