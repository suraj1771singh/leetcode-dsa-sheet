
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

class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode p = head;
        // count length of linked list
        while (p != null) {
            n++;
            p = p.next;
        }

        n = n / k;
        ListNode globalHead=null, connector=null, newTail=head, newHead=null;
        while (n-- > 0) {
            newTail = head;
            newHead = null;
            int m = k;
            // reverse k length LL
            while (m-- > 0) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            if(globalHead==null) globalHead=newHead;
            if(connector!=null) connector.next=newHead;
            connector=newTail;
        }
        newTail.next=head;
        return globalHead;
    }
}

//Time complexity : O(n), 2 passes
//Space complexity : O(1)