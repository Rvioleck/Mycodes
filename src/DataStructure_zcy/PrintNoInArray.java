package DataStructure_zcy;

public class PrintNoInArray {

    public void printNumberNoInArray(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        for (int val : arr){
            modify(val, arr);
        }
        for (int i = 0; i < arr.length; ++i){
            if (arr[i] != i + 1){
                System.out.println(i + 1);
            }
        }
    }

    private void modify(int val, int[] arr) {
        while (arr[val - 1] != val){
            int temp = arr[val - 1];
            arr[val - 1] = val;
            val = temp;
        }
    }

}
