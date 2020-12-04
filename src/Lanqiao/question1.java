package Lanqiao;

public class question1 {
    // 3A+7B+C = 315
    // 4A+10B+C = 420
    // A+B+C = ?
    public int jifen(){
        for (int a = 0; a <= 105; a++) {
            for (int b = 0; b <= 42; b++) {
                for (int c = 0; c <= 315; c++) {
                    if ( 3*a+7*b+c == 315 && 4*a+10*b+c == 420){
                        return a+b+c;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        question1 obj = new question1();
        System.out.println("第三笔订单共反"+obj.jifen()+"积分");
    }
}
