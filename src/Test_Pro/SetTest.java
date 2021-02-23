package Test_Pro;

/*
 * Set接口： 存储无序的、不可重复的数据 -->数学中的“集合”
 * 无额外的新的方法，均为collection中的方法。
 * 一、
 *     1、无序性：不等于随机性. 存储的数据在底层数组中并非按照数组索引的顺序添加， 而是根据数据的哈希值决定的、
 *     2、不可重复性：保证添加的元素按照equals()判断时，不能返回true，即相同的元素只能添加一个。
 * 二、添加元素的过程：以HashSet为例：
 *     我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
 *     此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（索引位置），判断
 *     数组此位置上是否已经有元素：
 *       如果此位置上没有其他元素，则元素a添加成功。 -->情况1
 *       如果此位置上有其他元素b（或以链表形式存在的多个元素），则比较元素a和元素b的hash值：
 *           如果hash值不相同，则元素a添加成功。 -->情况2
 *           如果hash值添加相同，进而需要调用元素a所在类的equals()方法：
 *               equals()返回true，元素a添加失败
 *               equals()返回false，则元素a添加成功--->情况3
 *
 *     对于添加成功的情况2和情况3而言：元素a与一级存在指定索引位置上数据以链表的方式存储。
 *     jdk7: 元素a放到数组中，指向原来的元素。
 *     jdk8： 原来的元素在数组中，指向元素a。
 *     HashSet底层：数组+链表
 *
 *     要求：向set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *        ：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 *
 *
 * */

import org.junit.Test;

import java.util.*;


public class SetTest {


    @Test
    public void hashSetTest() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(129);
        Iterator ite = set.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }


    public <T> Set<T> GetSetFromArray(T[] array) {
        return new HashSet<T>(Arrays.asList(array));
    }

    @Test
    public void hashSetTest2() {
        Integer nums[] = {1, 2, 3, 3, 2, 5};
        // 方法1
        Set set = new HashSet();
        for (int num :
                nums) {
            set.add(num);
        }
        System.out.println(set.toString());
        // 方法2
        HashSet set1 = (HashSet) GetSetFromArray(nums);
        System.out.println(set1);
    }

    @Test
    public void linkedHashSetTest() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(129);
    }

    @Test
    public void treeSetTest() {
        /*
         * 1. 向TreeSet中添加的数据，要求是相同类的对象。
         * 2. 两种排序方式：自然排序 和 定制排序。
         * */
        TreeSet set = new TreeSet();
        set.add(34);
        set.add(-34);
        set.add(43);
        set.add(11);
        set.add(8);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
