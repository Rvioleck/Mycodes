package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 */
public class RestoreIpAddresses {

    int n;

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        this.n = s.length();
        if (n > 16) {
            return res;
        }
        dfs(res, sb, s, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String s, int index, int count) {
        if (count == 4 && index == n) {
            res.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i > n) break;
            if (count > 4) break;
            String sub = s.substring(index, index + i);
            if (!isIP(sub)) continue;
            int len = sub.length();
            if (index == 0) {
                sb.append(sub);
            } else {
                sb.append(".").append(sub);
                len++;
            }
            dfs(res, sb, s, index + i, count + 1);
            sb.delete(sb.length() - len, sb.length());
        }

    }

    private boolean isIP(String ip) {
        if (ip.equals("0")) {
            return true;
        }
        if (ip.charAt(0) == '0') {
            return false;
        }
        int ipNum;
        try {
            ipNum = Integer.parseInt(ip);
        } catch (NumberFormatException e) {
            return false;
        }
        return ipNum <= 255 && ipNum >= 0;
    }
}
