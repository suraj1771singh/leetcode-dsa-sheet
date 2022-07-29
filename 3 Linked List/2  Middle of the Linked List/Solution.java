
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

// fast and slow pointers approach
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fp = head, sp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;

        }
        return sp;
    }
}