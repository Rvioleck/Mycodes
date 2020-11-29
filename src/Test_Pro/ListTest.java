package Test_Pro;

/*
*   ArrayList,LinkedList, Vector的异同
* 同： 三个类都是实现List接口， 存储数据的特点相同：存储有序的，可重复的数据
* 不同： ArrayList作为List接口的主要实现类，编程不安全，效率高，底层使用Object[]存储
*       Vector作为List接口的古老实现类：线程安全，效率低，底层使用Object[]存储
*       LinkedList底层使用双向链表存储，对于频繁的插入、删除操作，使用这个比ArrayList效率高
*
* ArrayList：
*   jdk 7的情况下
*     ArrayList list = new ArrayList(); // 底层创建了长度是10的object[]数据
*     list.add(123); // elementData[0] = new Integer(123);
*     ...
*     list.add(11); // 如果此次的添加导致elementData数组容量不够，则扩容。
*     默认情况下，扩容为原来容量的1.5倍，同时需要将原数组中的数据复制到新的数组中。
*
*     结论：建议使用带参的的构造器，ArrayList list = new ArrayList(int capacity)
*   jdk 8中的变化：
*     ArrayList list = new ArrayList(); 底层elementData初始化为{}，并未创建长度
*     在第一次调用add()时，底层才会创建长度10的数据，并将123,添加到elementData
*     后续的添加和扩容的后续操作与jdk 7 无异

*
*  */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    @Test
    public void arrayListTest1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        System.out.println(list);
        // void add(int index, Object ele):
        list.add(1, "BB");
        System.out.println(list);

        // boolean addAll(int index, Collection eles):
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);
    }

    @Test
    public void arrayListTest2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        // int indexOf(Object obj)
        int index = list.indexOf(456);
        System.out.println(index);
        // int lastIndexOf(Object obj): 不存在返回-1
        int lastIndex = list.lastIndexOf(456);
        System.out.println(lastIndex);
        // Object remove(int index)： 移除指定位置的元素并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);
        // List subList(int fromIndex, int toIndex): 返回子列表，左闭右开
        List sub = list.subList(2, 4);
        System.out.println(sub);

    }
}
