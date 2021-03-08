package LeetCode_JAVA.String;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int left = 0, right = words.length -1;
        while (left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            if (!word.equals("")){
                res.append(word).append(" ");
            }
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = new String("the sky is  blue!");
        s = new ReverseWords().reverseWords(s);
        System.out.println(s);
    }

}
