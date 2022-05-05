package DataStructure_zcy;

import LeetCode_JAVA.BinaryTree.TreeNode;

public class MorrisTraverse {

    public void morris(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { // 第二次来到cur
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public void morrisPre(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { // 第一次来到cur
                    System.out.println(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { // 第二次来到cur
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    public void morrisIn(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { // 第二次来到cur
                    mostRight.right = null;
                }
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public void morrisPos(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { // 第二次来到cur
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
    }

    public void printEdge(TreeNode x) {
        TreeNode tail = reverseEdge(x);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
        reverseEdge(x);
    }

    public TreeNode reverseEdge(TreeNode x) {
        TreeNode pre = null;
        TreeNode next;
        while (x != null) {
            next = x.right;
            x.right = pre;
            pre = x;
            x = next;
        }
        return pre;
    }

}
