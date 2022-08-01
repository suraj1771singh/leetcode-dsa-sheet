import java.util.PriorityQueue;

//---------------USING HEAP
/*
 * 1) maintain a heap of k elements , 
 * 2) it contians the smallest element of each list , on every step
 * 3) l1,l2....lk points to smallest element on each list 
 * 4) so every time we will get smallest element from heap 
 *    and add it to answer linked list
 */

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1) return lists[0];
        if(lists.length==0) return null;
        
        // create min heap of k elements
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }
        ListNode head;
        ListNode l = new ListNode(0);
        head = l;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next!=null) pq.add(node.next);
            l.next=node;
            l=l.next;
        }
        return head.next;
    }

}
//Time complexity : O(nk*log k) , n= avg length of each linked list
//Space complexity : O(k)
