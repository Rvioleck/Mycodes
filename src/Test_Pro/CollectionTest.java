package Test_Pro;

import org.junit.Test;

import java.util.*;

class Person{
    private String name;
    private int age;
    public Person(){
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }
}


public class CollectionTest {
    // ArrayList有序
    @Test
    public void test1(){
        // contains() and containsAll()
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        // contains(Object obj): 判断集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom"))); // 值比较
        System.out.println(coll.contains(new Person("Jerry", 20)));
        // containsAll(Collection obj)
        Collection coll1 = Arrays.asList(123, "Tom");
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2(){
        // remove(Object obj)
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        coll.remove(1234);
        System.out.println(coll);

        // removeAll(Collection obj) 差集
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);

        // retainAll(Collection obj) 交集
        Collection coll1 = Arrays.asList(123, 456, 789);
        coll.retainAll(coll1);
        System.out.println(coll);

        // equals(Object obj): 返回True需要当前集合和形参集合元素对应相同
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add("Tom");
        coll2.add(false);
        System.out.println(coll.equals(coll2));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        // hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // toArray(): 集合->数组
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
        // Arrays.asList()
        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());

        // iterator(): 返回Iterator接口的实例


    }
}
