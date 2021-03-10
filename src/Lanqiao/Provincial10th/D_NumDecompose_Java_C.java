package Lanqiao.Provincial10th;

import java.util.ArrayList;
import java.util.List;

public class D_NumDecompose_Java_C {

    List<Integer> nums = new ArrayList<>();

    private void notContain2And4(int num){
        int num0 = num;
        while (num != 0){
            int digit = num % 10;
            if (digit == 2 || digit == 4){
                return;
            }
            num /= 10;
        }
        nums.add(num0);
    }

    private int decompose(int num){
        for (int i = 1; i <= num - 3; i++) {
            notContain2And4(i);
        }
        int count = 0;
        int x, y, z; // 记录三个因子
        first : for (int i = 0; i < nums.size(); i++) {
            x = nums.get(i);
            second : for (int j = i + 1; j < nums.size(); j++) {
                y = nums.get(j);
                if (x + y >= num) continue first;
                for (int k = j + 1; k < nums.size(); k++) {
                    z = nums.get(k);
                    if (x + y + z > num) continue second;
                    if (x + y + z == num){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 2019;
        System.out.println(new D_NumDecompose_Java_C().decompose(num));
    }

}
