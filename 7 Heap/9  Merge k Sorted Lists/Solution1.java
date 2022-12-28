import java.util.*;

//Definition for singly-linked list.
class ListNode {
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
}

// ---------------USING HEAP
/*
 * 1) maintain a heap of k elements ,
 * 2) it contains the smallest element of each list , on every step
 * 3) l1,l2....lk points to smallest element on each list
 * 4) so every time we will get smallest element from heap
 * and add it to answer linked list
 */

public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1)
            return lists[0];
        if (lists.length == 0)
            return null;

        // create min heap of k elements
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }
        ListNode dumy = new ListNode(0);
        ListNode head = dumy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            if (node.next != null)
                pq.add(node.next);
            head = head.next;
        }
        return dumy.next;

    }

}
// Time complexity : O(nk*log k)
// Space complexity : O(k)