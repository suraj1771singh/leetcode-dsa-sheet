
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
    public int getDecimalValue(ListNode head) {
        int n = 0, ans = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        p = head;
        while (p != null) {
            ans += p.val * Math.pow(2, --n);
            p = p.next;
        }
        return ans;
    }
}
// Time complexity : O(n), 2 passes
// Space complexity : O(1)