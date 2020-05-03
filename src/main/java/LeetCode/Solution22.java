package LeetCode;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution22 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        PriorityQueue<ListNode> sortList = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode temp = res;
        if (lists.length == 0) {
            return null;
        }
        for (ListNode list : lists) {
            if (list != null) {
                sortList.offer(list);
            }
        }
        while (!sortList.isEmpty()) {
            ListNode node = sortList.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next!=null){
                sortList.offer(node.next);
            }

        }
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
