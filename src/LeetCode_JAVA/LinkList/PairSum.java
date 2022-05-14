package LeetCode_JAVA.LinkList;

public class PairSum {

    public int pairSum(ListNode head) {
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null){ // 找中点
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = null;
        while (slow != null){ // 中点开始翻转链表
            ListNode next = slow.next;
            slow.next = fast;
            fast = slow;
            slow = next;
        }
        int max = 0;
        while (fast != null){ // 求最大值
            max = Math.max(max, head.val + fast.val);
            fast = fast.next;
            head = head.next;
        }
        return max;
    }

}
