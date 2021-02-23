package LeetCode_JAVA.LinkList;

import java.util.Arrays;

public class SplitListToParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int nodeNum = 0;
        ListNode cur = root, pre = new ListNode();
        while (cur != null) {
            nodeNum++;
            cur = cur.next;
        }
        cur = root;
        int average = nodeNum / k;
        int surplus = nodeNum % k;
        for (int i = 0; i < k; i++) {
            int count = surplus-- > 0 ? average + 1 : average;
            while (count-- != 0) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
            res[i] = root;
            root = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(new SplitListToParts().splitListToParts(l1, 5)));
    }

}
