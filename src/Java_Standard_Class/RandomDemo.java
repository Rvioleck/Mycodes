package Java_Standard_Class;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("随机产生一个随机整数：" + r.nextInt());
        System.out.println("随机产生一个0~10的随机整数：" + r.nextInt(10)); // 0~10不包含10
        System.out.println("随机产生一个布尔值：" + r.nextBoolean());
        System.out.println("随机产生一个双精度值：" + r.nextDouble());
        System.out.println("随机产生一个浮点值：" + r.nextFloat());
        System.out.println("随机产生一个概率密度为高斯分布的双精度值：" + r.nextGaussian());
        // 随机生成字符数组并排序
//		char[] cc = new char[20];
//		Random r = new Random();
//		for(int i=0; i<cc.length; i++){
//			cc[i] = (char)('A'+r.nextInt(26));
//		}
//		// 排序前
//		System.out.println(new String(cc));
//		// 排序后
//		Arrays.sort(cc);
//		System.out.println(new String(cc));

    }
}
