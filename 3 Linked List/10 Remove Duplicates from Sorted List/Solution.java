
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

// ----------ALGO
/*
 * 1) use two pointers at adjacent
 * 2) if value of both pointers is different just move them ahead
 * 3) else just move ahead pointer and link curr to ahead pointer
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode ahead = head.next;
        while (ahead != null) {
            if (curr.val == ahead.val) {
                ahead = ahead.next;
                curr.next = ahead;
            } else {
                ahead = ahead.next;
                curr = curr.next;
            }
        }
        return head;

    }
}
// Time complexity : O(n)
// Space complexity : O(1)