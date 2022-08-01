
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

//--------------ALGO
/*
 * 1) find middle using slow and fast pointer approach
 * 2) reverse linked list from middle to end (slow pointer)
 * 3) now keep fast pointer at head, and slow pointer at reversed LL
 * 4) now check for palindrome 
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode sp = head, fp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        sp = fp==null ? sp : sp.next;
        sp = reverseLinkedList(sp);
        fp = head;
        while(sp!=null){
            if(sp.val!=fp.val) return false;
            sp=sp.next;
            fp=fp.next;
        }
        return true;

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