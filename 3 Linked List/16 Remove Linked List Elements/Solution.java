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

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        
        while(head!=null && head.val==val) head=head.next;
        ListNode curr = head, prev = null;
        while (curr != null) {
            if (curr.val == val){ 
                curr=curr.next;
                prev.next = curr;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
//Time complexity : O(n)
//Space complexity : O(1)