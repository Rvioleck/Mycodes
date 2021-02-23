package Test_Pro;

public class TernaryOperator {
    // 1 假如表达式1和表达式2具有相同的类型，那么整个条件运算符结果的类型就是这个类型。
    // 2 假如一个表达式的类型是T，T是byte或short或char，另一个表达式的类型是int类型的常量表达式，
    // 而且这个常量表达式的值是可以用类型T表示的（也就是说，常量表达式的值是在类型T的取值范围之内），那么整个条件运算符结果的类型就是T。
    // 3 除以上情况外，假如表达式1和表达式2的类型不同，那么将进行类型提升，整个条件运算符结果的类型就是提升后的类型
    public static void main(String[] args) {
        int n = 8;
        System.out.println(n > 6 ? 1 : 2.0);//1.0  规则3
        System.out.println(n > 6 ? 1 : 2);//1 规则1
        System.out.println(n > 6 ? 'a' : 2L);//97L 规则3
        System.out.println(n > 6 ? 'a' : 2);//a  规则2
        System.out.println(n > 6 ? 'a' : Character.MAX_VALUE);//a 规则2
        System.out.println(n = (n > 6 ? 'a' : Character.MAX_VALUE + 1));//97 规则3
    }
}
