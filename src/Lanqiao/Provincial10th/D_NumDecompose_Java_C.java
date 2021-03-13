package Lanqiao.Provincial10th;

import java.util.ArrayList;
import java.util.List;

public class D_NumDecompose_Java_C {

    // 记录不含数字2和4的数字
    List<Integer> nums = new ArrayList<>();

    /**
     * 记录num是否不含数字2和数字4
     * @param num
     */
    private void notContain2And4(int num){
        int num0 = num;           // 存取副本，若满足条件则加入集合nums
        while (num != 0){         // 对num的每一位进行判断其是否包含数字2,4
            int digit = num % 10; // 取num的个位数
            if (digit == 2 || digit == 4){
                // 如果个位数为2或4，直接退出函数
                return;
            }
            num /= 10; // 如num = 198 -> num = 19 相当于将十位9变为个位
            // (本质是循环取num的个位进行判断)
        }
        // 若while遍历完毕仍未退出函数，则其不含数字2,4，将其副本加入集合nums
        nums.add(num0);
    }

    /**
     * 计算数num不包含数字2和数字4的 三个 数所有和的组合
     * @param num
     * @return
     */
    private int decompose(int num){
        for (int i = 1; i <= num; i++) {
            // 将所有不大于num的所有不包含2和4的元素加入集合
            notContain2And4(i);
        }
        int count = 0;   // 记录结果
        int x, y, z;     // 记录三个因子
        // 对集合nums进行x, y, z的三层遍历
        first : for (int i = 0; i < nums.size(); i++) {
            x = nums.get(i);    // 遍历的为集合nums的下标, 所以x的值为get(i)，相当于C语言中取数组下标x = nums[i]
            second : for (int j = i + 1; j < nums.size(); j++) {
                y = nums.get(j);
                // 在第二层y的遍历中如果此时的x + y >= num的话
                // 则必不可能存在 x + y + z == num (因为还没有加z(z > 0))
                // 此时continue first (continue + label为Java的特殊语法，跳转特定层的for)
                // 正常的continue只能结束当前即second层的当前循环
                // C语言实现此类跳转需要加设一个flag来记录是否满足条件
                if (x + y >= num) continue first;
                for (int k = j + 1; k < nums.size(); k++) {
                    z = nums.get(k);
                    // 同上
                    if (x + y + z > num) continue second;
                    if (x + y + z == num){ // 满足条件count++
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
