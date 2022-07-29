

//------------ALGO
/*
 * 1) Copy value to next node to given node
 * 2) remove next node 
 */
 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}