package Lanqiao;

public class question3 {

    public int decompose(int num){
        int count = 0;
        if (num <= 6){
            return count;
        }
        for (int i = 1; i <= num; i++) {
            if (contain2_4(i))
                continue;
            for (int j = i + 1; j <= num - i; j++) {
                if (contain2_4(j))
                    continue;
                for (int k = j + 1; k <= num - i - j; k++) {
                    if (contain2_4(k))
                        continue;
                    else if (i+j+k == num)
                        count++;
                }
            }
        }
        return count;
    }

    public boolean contain2_4(int num){
        while(num != 0){
            int digit = num%10;
            if (digit == 2 || digit == 4){
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        question3 obj = new question3();
        System.out.println(obj.decompose(2019));
    }
}
