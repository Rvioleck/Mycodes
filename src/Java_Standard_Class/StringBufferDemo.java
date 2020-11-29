package Java_Standard_Class;

public class StringBufferDemo {
    public static void main(String[] args) {
        /* 添加操作append()
         *  public StringBuffer append(boolean b)(char c)(char[] str)*/
//		StringBuffer sbf = new StringBuffer("1+2=");
//		int i = 3;
//		sbf.append(i);
//		System.out.println(sbf);
        /* 插入操作insert()
         *  public StringBuffer insert(int offset, boolean b)(int offset, char[] str)(int offset, String str) */
//		StringBuffer sbf = new StringBuffer("1+=2");
////		char[] n = {'1', '2'};
////		String n = "1";
//		sbf.insert(2, n); // 下标2的位置插入n
//		System.out.println(sbf);
        /* 刪除字符delete() */
//		StringBuffer sbf = new StringBuffer("You are the best");
//		sbf.delete(0, 5); // 刪除下标0~5之间的字符（不包括5）
//		sbf.deleteCharAt(3); // 删除下标为3的字符
//		System.out.println(sbf);
        /* 内容替换 */
//		StringBuffer sbf = new StringBuffer("You are the best!");
//		String str = "I'm";
//		sbf.replace(0, 7, str); // 替换下标0~7之间的字符（不包括7）
//		System.out.println(sbf);
        /* 翻转字符 */
//		String strSource = new String("I love java");
//		StringBuffer sbf = new StringBuffer(strSource);
//		System.out.println(sbf.reverse()); // StringBuffer的翻转方法
//		String strDest = reverseIt(strSource);
//		System.out.println(strDest);
//	}
//	public static String reverseIt(String source){
//		int i, len = source.length();
//		StringBuffer dest = new StringBuffer(len);
//		for(i = (len-1); i>=0; i--){
//			dest.append(source.charAt(i));
//		}
//		return dest.toString();
    }
}
