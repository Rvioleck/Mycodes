package DataStructure_zcy;

public class NeedParentheses {

    public int needParentheses(String str){
        int t = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); ++i){
            if (str.charAt(i) == '('){
                t++;
            } else {
                if (t == 0){
                    ans++;
                } else { // t > 0
                    t--;
                }
            }
        }
        return t + ans;
    }

}
