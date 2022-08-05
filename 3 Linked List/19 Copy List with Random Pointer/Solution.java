
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        // copy original linked list
        Node h1 = head;
        Node dummy = new Node(0);
        while (h1 != null) {
            Node temp = new Node(h1.val);
            temp.next = h1.next;
            h1.next = temp;
            h1 = h1.next.next;
        }
        // copy random pointer
        h1 = head;
        while (h1 != null) {
            if (h1.random != null) {
                h1.next.random = h1.random.next;
            } else
                h1.next.random = h1.random;
            h1 = h1.next.next;
        }
        // delinking from original list
        h1 = head;
        dummy.next = head;
        Node cloneHead = dummy;
        while (h1 != null) {
            dummy.next = h1.next;
            h1.next = dummy.next.next;
            h1 = h1.next;
            dummy = dummy.next;

        }
        return cloneHead.next;
    }
}
