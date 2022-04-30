package LeetCode_JAVA.DFS_BFS;

public class PrintAllSubsequence {

    public static void printAllSubsequence(String str){
        char[] chs = str.toCharArray();
        dfs(chs, 0);
    }

    public static void dfs(char[] str, int i){
        if (i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        dfs(str, i + 1);
        char temp = str[i];
        str[i] = '\0';
        dfs(str, i + 1);
        str[i] = temp;
    }


    public static void main(String[] args) {
        printAllSubsequence("123");
    }
}
