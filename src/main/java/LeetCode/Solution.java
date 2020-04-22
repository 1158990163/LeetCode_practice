package LeetCode;

import java.util.Stack;

//链表的两数之和
public class Solution {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }


        ListNode Node = null;
        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry!=0) {
            int sum = 0;

            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            sum += carry;
            if (sum >= 10) {
                ListNode NowNode = new ListNode(sum - 10);
                NowNode.next = Node;
                Node = NowNode;
                carry = 1;
            } else {
                ListNode NowNode = new ListNode(sum);
                NowNode.next = Node;
                Node = NowNode;
                carry = 0;

            }

        }
        return Node;

    }
}
