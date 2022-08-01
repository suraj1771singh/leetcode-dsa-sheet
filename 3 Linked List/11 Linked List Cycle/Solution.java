// Definition for singly-linked list.
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

// ------------FAST AND SLOW POINTERS APPROACH

public class Solution {
    public boolean hasCycle(ListNode head) {
        if ((head == null) || (head.next == null))
            return false;
        ListNode sp = head;
        ListNode fp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp)
                return true;
        }
        return false;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)