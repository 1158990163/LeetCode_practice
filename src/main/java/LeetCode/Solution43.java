package LeetCode;

//25. K 个一组翻转链表

import java.util.Stack;

public class Solution43 {
    public ListNode reverseKGroup(ListNode head, int k) {

        Stack<ListNode> stack = new Stack<>();
        ListNode res = new ListNode(0);
        ListNode node = new ListNode(0);
        res.next = node;
        while (head.next != null) {
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    node.next = stack.pop();
                    node = node.next;
                }
            }
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            node.next = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
        }

        return res.next.next;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(0);
        ListNode t2 = new ListNode(1);
        ListNode t3 = new ListNode(2);
        ListNode t4 = new ListNode(3);
        ListNode t5 = new ListNode(4);
        ListNode t6 = new ListNode(5);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = t6;
        Solution43 a = new Solution43();
        ListNode s = a.reverseKGroup(t1, 3);
        while (s.next != null) {
            System.out.print(s.val);
            s = s.next;
        }
    }
}
