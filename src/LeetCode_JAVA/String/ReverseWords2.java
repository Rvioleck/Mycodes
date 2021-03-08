package LeetCode_JAVA.String;

public class ReverseWords2 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i = 0, j = 0;
        while (i < len){
            while (j <= len - 1 && chars[j] != ' '){
                j++;
            }
            int left = i, right = j - 1;
            while (left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            j++;
            i = j;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        s = new ReverseWords2().reverseWords(s);
        System.out.println(s);
    }

}
