package DataStructure_zcy.dfs_dp;

public class EatGrass {

    public String winner(int n){
        if (n < 5){
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
        int base = 1;
        while (base <= n){
            if (winner(n - base).equals("后手")){
                // 子过程中自己获胜，那么就获胜了
                return "先手";
            }
            if (base > n / 4){ // 防止base*4溢出
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    public String winner1(int n){
        if (n % 5 == 0 || n % 5 == 2){
            return "后手";
        }
        return "先手";
    }

}
