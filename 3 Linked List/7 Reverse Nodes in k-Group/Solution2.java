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

class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode globalHead = null, connector = null, newTail = head, newHead = null;

        while (head != null) {
            // checking if next k nodes exist or not;
            ListNode temp = head;
            int m = k;
            while (m-- > 0 && temp != null) temp = temp.next;
            if (temp == null) break;

            // if next k nodes exits then reverse it
            m = k;
            newTail = head;
            newHead = null;
            // reverse k length LL
            while (m-- > 0) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            if (globalHead == null) globalHead = newHead;
            if (connector != null) connector.next = newHead;
            connector = newTail;
        }
        newTail.next = head;
        return globalHead;
    }
}
//Time complexity : O(n), single pass
//Space complexity : O(1)
