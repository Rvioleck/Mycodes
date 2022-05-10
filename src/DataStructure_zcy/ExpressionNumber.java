package DataStructure_zcy;

public class ExpressionNumber {

    public boolean isValid(char[] exp) {
        if (((exp.length) & 1) == 0) {
            return false;
        }
        for (int i = 0; i < exp.length; i++) {
            if ((i & 1) == 0) {
                if ((exp[i] != '1') && (exp[i] != '0')) {
                    return false;
                }
            } else {
                if ((exp[i] != '&') && (exp[i] != '|') && (exp[i] != '^')) {
                    return false;
                }
            }
        }
        return true;
    }

    public int expressionNumber_dfs(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return dfs(exp, desired, 0, exp.length - 1);
    }

    private int dfs(char[] exp, boolean desired, int L, int R) {
        if (L == R) {
            if (exp[L] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = L + 1; i < R; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += dfs(exp, true, L, i - 1) * dfs(exp, true, i + 1, R);
                        break;
                    case '|':
                        res += dfs(exp, true, L, i - 1) * dfs(exp, true, i + 1, R);
                        res += dfs(exp, true, L, i - 1) * dfs(exp, false, i + 1, R);
                        res += dfs(exp, false, L, i - 1) * dfs(exp, true, i + 1, R);
                        break;
                    case '^':
                        res += dfs(exp, true, L, i - 1) * dfs(exp, false, i + 1, R);
                        res += dfs(exp, false, L, i - 1) * dfs(exp, true, i + 1, R);
                        break;
                }
            }
        } else {
            for (int i = L + 1; i < R; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += dfs(exp, true, L, i - 1) * dfs(exp, false, i + 1, R);
                        res += dfs(exp, false, L, i - 1) * dfs(exp, true, i + 1, R);
                        res += dfs(exp, false, L, i - 1) * dfs(exp, false, i + 1, R);
                        break;
                    case '|':
                        res += dfs(exp, false, L, i - 1) * dfs(exp, false, i + 1, R);
                        break;
                    case '^':
                        res += dfs(exp, false, L, i - 1) * dfs(exp, false, i + 1, R);
                        res += dfs(exp, true, L, i - 1) * dfs(exp, true, i + 1, R);
                        break;
                }
            }
        }
        return res;
    }

    public int expressionNumber_dp(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        int N = exp.length;
        int[][] tMap = new int[N][N];
        int[][] fMap = new int[N][N];
        for (int i = 0; i < N; i += 2) {
            tMap[i][i] = exp[i] == '1' ? 1 : 0;
            fMap[i][i] = exp[i] == '0' ? 1 : 0;
        }
        for (int L = N - 3; L >= 0; L -= 2){
            for (int R = L + 2; R < N; R += 2){
                for (int i = L + 1; i < R; i += 2) {
                    switch (exp[i]) {
                        case '&':
                            tMap[L][R] += tMap[L][i - 1] * tMap[i + 1][R];
                            fMap[L][R] += tMap[L][i - 1] * fMap[i + 1][R];
                            fMap[L][R] += fMap[L][i - 1] * tMap[i + 1][R];
                            fMap[L][R] += fMap[L][i - 1] * fMap[i + 1][R];
                            break;
                        case '|':
                            tMap[L][R] += tMap[L][i - 1] * tMap[i + 1][R];
                            tMap[L][R] += tMap[L][i - 1] * fMap[i + 1][R];
                            tMap[L][R] += fMap[L][i - 1] * tMap[i + 1][R];
                            fMap[L][R] += fMap[L][i - 1] * fMap[i + 1][R];
                            break;
                        case '^':
                            tMap[L][R] += tMap[L][i - 1] * fMap[i + 1][R];
                            tMap[L][R] += fMap[L][i - 1] * tMap[i + 1][R];
                            fMap[L][R] += tMap[L][i - 1] * tMap[i + 1][R];
                            fMap[L][R] += fMap[L][i - 1] * fMap[i + 1][R];
                            break;
                    }
                }
            }
        }
        return desired ? tMap[0][N - 1] : fMap[0][N - 1];
    }

    public static void main(String[] args) {
        String exp = "1^0|1&0&1|1^0";
        System.out.println(new ExpressionNumber().expressionNumber_dfs(exp, false));
        System.out.println(new ExpressionNumber().expressionNumber_dp(exp, false));
    }

}
