package LeetCode_JAVA.LinkList;

public class AddTwoNumbers {
    int flag = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2, pre = null;
        while (cur1 != null && cur2 != null){
            cur1.val += cur2.val + flag;
            if (cur1.val >= 10){
                flag = 1;
                cur1.val -= 10;
            } else {
                flag = 0;
            }
            pre = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1 == null && pre != null){
            pre.next = cur2;
            cur1 = cur2;
        }
        while (cur1 != null){
            if (flag == 1){
                cur1.val++;
                if (cur1.val >= 10){
                    flag = 1;
                    cur1.val -= 10;
                } else {
                    flag = 0;
                }
            }
            pre = cur1;
            cur1 = cur1.next;
        }
        if (flag == 1 && pre != null){
            pre.next = new ListNode(1);
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{9, 9, 9, 9});
        ListNode l2 = ListNode.creat(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(res);
    }
}
