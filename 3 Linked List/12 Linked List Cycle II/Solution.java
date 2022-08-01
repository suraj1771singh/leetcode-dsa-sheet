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
    public ListNode detectCycle(ListNode head) {
        ListNode sp = head, fp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                fp = head;
                while (fp != sp) {
                    sp = sp.next;
                    fp = fp.next;
                }
                return sp;
            }
        }
        return null;

    }
}
// Time complexity : O(n)
// Space complexity : O(1)