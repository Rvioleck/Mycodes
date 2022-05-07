package LeetCode_JAVA.GreedyAlgorithm;

public class MinOps {
    /*
      假设s和m初始化，s = "a"; m = s; 再定义两种操作，
      第一种操作:m= s; s = s +s ;
      第二种操作:s = s + m;
      求最小的操作步骤数,可以将s拼接到长度等于n
    * */

    public boolean isPrim(int n){
        for (int i = 2; i <= Math.sqrt(n); ++i){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public int minOps(int n){
        if (n < 2){
            return 0;
        }
        if (isPrim(n)){
            return n - 1;
        }
        int sum = 0, count = 0;
        for (int i = 2; i <= n; ++i){
            while (n % i == 0){
                sum += i;
                count++;
                n /= i;
            }
        }
        return sum - count;
    }

    public static void main(String[] args) {
        System.out.println(new MinOps().minOps(21));
    }

}
