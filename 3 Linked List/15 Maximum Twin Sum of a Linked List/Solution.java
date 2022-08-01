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

// -------------THIS PROBLEM IS SIMILAR LIKE PALINDROME PROBLEM

class Solution {
    public int pairSum(ListNode head) {
        ListNode sp = head, fp = head;
        int ans=0;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        sp = fp == null ? sp : sp.next;
        sp = reverseLinkedList(sp);
        fp = head;
        while (sp != null) {
            ans = Math.max(ans, fp.val + sp.val);
            sp=sp.next;
            fp=fp.next;
        }
        return ans;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
//Time complexity : O(n)
//Space complexity : O(1)