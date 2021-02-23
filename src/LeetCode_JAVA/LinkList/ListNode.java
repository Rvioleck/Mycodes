package LeetCode_JAVA.LinkList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode creat(int[] nums) {
        ListNode pre = new ListNode(0), cur = pre;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return pre.next;
    }

    @Override
    public String toString() {
        ListNode tmp = this;
        StringBuffer sb = new StringBuffer();
        while (tmp != null) {
            sb.append(tmp.val);
            sb.append("->");
            tmp = tmp.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode l1 = creat(new int[]{1, 2, 3, 4, 5});
        System.out.println(l1);
    }
}
