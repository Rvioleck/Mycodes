package Java_Standard_Class;

public class StringDemo {
    // 不可更改字符串String
    public static void main(String[] args) {
        /* 调用String类的构造方法，使用子串常量，构造新字符串对象 */
//		String s;
//		s = new String("We are students");
//		s = "We are students";
//		String s = new String("We are students");
//		String s = new String(); // 初始化为空

        /* 由字符数组构造字符串 */
//		char cDem01[] = {'1', '2', '3', '4', '5'};
//		char cDem02[] = {'2', '3', '4', '5'};
//		String s1 = new String(cDem01);
//		String s2 = new String(cDem02, 1, 2); // 从下标1的字符开始构造长度为2的字符串

        /* 由字节数组构造字符串 */
//		byte cDemo03[] = {66, 67, 68};
//		byte cDemo04[] = {65, 66, 67, 68};
//		String s3 = new String(cDemo03);
//		String s4 = new String(cDemo04, 1, 3); // 从下标为1的字符开始构造长度为3的字符串

        /* 字符串长度计算 */
//		String s = "We are Students", tom = "我们是学生";
//		int n1, n2;
//		n1 = s.length();  // n1 = 15
//		n2 = tom.length(); // n2 = 5

        /* 字符串比较 */
//		String tom = new String("we are students");
//		String boy = new String("We are students");
//		String jerry = new String("we are students");
//		System.out.println(tom.equals(boy));   // 比较值相等
//		System.out.println(tom.equals(jerry));
//		System.out.println(tom.equalsIgnoreCase(boy)); // 比较值相等，忽略大小写
//		System.out.println(tom.equalsIgnoreCase(jerry));

        /* starsWith()和endsWith()方法 */
// boolean startsWith(String s) 判断当前字符串对象的前缀是否是s
// boolean endsWith(String s) 判断当前字符串对象的后缀是否是s
//		String tom = "2203214512515021", jerry = "210030214412022";
//		System.out.println(tom.endsWith("022")); // false
//		System.out.println(jerry.endsWith("022")); // true
//		System.out.println(tom.startsWith("220")); // true
//		System.out.println(jerry.startsWith("220")); // false

        /* compareTo()和compareIgnoreCase()方法 */
// int compareTo(String s) 让当前字符串与s进行字符串比较
// int compareIgnoreCase(String s) 让当前字符串与s进行字符串比较,忽略大小写
//		String str = "abcde";
//		System.out.println(str.compareTo("boy")); // <0
//		System.out.println(str.compareTo("abadef")); // >0
//		System.out.println(str.compareTo("abcde")); // =0
//
        /* 将字符串数组按字典序重新排列 */
//		String[] a = {"Java", "Basic", "C++", "Fortran", "SmallTalk"};
//		for(int i=0; i<a.length; i++){
//			String temp = a[i];
//			int min = i;
//			for(int j=i+1; j<a.length; j++){
//				if(a[min].compareTo(a[j]) > 0){
//					min = j;
//				}
//			}
//			a[i] = a[min];
//			a[min] = temp;
//		}
//		for(int i=0; i<a.length; i++){
//			System.out.print(" "+a[i]);
//		}
        /* 字符串检索 */
//		String strSource = "I love Java";
//		int nPosition;
//		// 正向搜索
//		nPosition = strSource.indexOf('v');
//		nPosition = strSource.indexOf('a', 9); // 从下标9开始正向检索
//		nPosition = strSource.indexOf("love");
//		nPosition = strSource.indexOf("love", 0);
//		// 反向搜索
//		nPosition = strSource.lastIndexOf('v');
//		nPosition = strSource.lastIndexOf('a', 9); // 从下标9开始反向检索
//		System.out.println(nPosition);
        /* 字符串的截取 */
//		String strSource = "Java is interesting";
//		String strNew1 = strSource.substring(5); // 从下标5开始向后截取
//		String strNew2 = strSource.substring(5,6); // 从下标5开始到下标6(不包含)截取
//		System.out.println(strNew1);
        /* 字符串的替换 */
//		String s = "I mist theep ";
//		String temp = s.replace('t', 's');
//		String temp2 = s.trim();
//		System.out.println(s+temp2);
        /* 连接两个字符串 */
        // 同于操作符 +
//		String strString = new String("01234");
//		String strAnoString = "56789";
//		strString = strString.concat(strAnoString);
//		System.out.println(strString);

    }
}
