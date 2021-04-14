package Test_Pro;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;


public class OverrideCompareToAndCompare {
    // Comparable 自然排序重写compareTo， Comparator 定制排序重写compare
    // Comparable接口方式一旦一定， 保证Comparable接口实现类的任何对象在任何位置都可以比较大小
    // Comparator属于临时比较
    @Test
    public void comparableTest() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("miMouse", 16);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("eellMouse", 43);
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(arr[0].compareTo(arr[1]));
    }

    @Test
    public void comparatorTest() {
        String[] arr = {"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr, (o1, o2) -> {
            if (o1 != null && o2 != null) {
                return -o1.compareTo(o2);
            }
//                return 0;
            throw new RuntimeException("输入类型不一致");
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void comparatorTest2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("miMouse", 16);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("eellMouse", 43);
        // 指明商品比较大小的方式：按照产品名称从低到高，再按照价格从高到低排序。
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
