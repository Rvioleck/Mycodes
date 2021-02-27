package LeetCode_JAVA.Sort_Algorithm;

import java.util.*;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > max){
                max = arr1[i];
            }
        }
        int[] frequency = new int[max + 1];
        for (int x : arr1){
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                ans[index++] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RelativeSortArray().relativeSortArray(
                new int[]{2,3,1,3,2,4,6,7,9,2,19},
                new int[]{2,1,4,3,9,6}
        )));
    }

}
