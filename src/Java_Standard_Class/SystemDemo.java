package Java_Standard_Class;

public class SystemDemo {
    public static void main(String[] args) {
        // 计算程序的执行时间
//		long start, end, sum = 0, times = 1_000_000_000;
//		System.out.println("执行"+times+"次循环需要的时间");
//		start = System.currentTimeMillis();
//		for (int i=0; i<times; i++){
//			sum += i*i;
//		}
//		end = System.currentTimeMillis();
//		System.out.println("需要的时间是："+(end-start)+"ms");

        // 复制数组arraycopy()实例
//		byte a[] = {65, 66, 67, 68, 69, 70, 71};
//		byte b[] = {88, 88, 88, 88, 88, 88, 88, 88, 88, 88};
//		System.out.println("a=" + new String(a));
//		System.out.println("b=" + new String(b));
//		System.arraycopy(a, 0, b, 0, a.length);
//		System.out.println("a=" + new String(a));
//		System.out.println("b=" + new String(b));
//		System.arraycopy(b, 5, a, 0, 4);
//		System.out.println("a=" + new String(a));
//		System.out.println("b=" + new String(b));

        // 计算内存使用情况
        Runtime r = Runtime.getRuntime();
        System.out.println("Java虚拟机总内存：" + r.totalMemory());
        r.gc();
        System.out.println("空闲内存l:" + r.freeMemory());
        String[] ss = new String[1000000];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = new String("Java程序设计");
        }
        System.out.println("空闲内存2：" + r.freeMemory());
        for (int i = 0; i < ss.length; i++) {
            ss[i] = null;
        }
        r.gc();
        System.out.println("空闲内存3：" + r.freeMemory());
    }
}
