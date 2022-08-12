class Node {
    int val;
    Node prev;
    Node next;

    Node(int a) {
        val = a;
        prev = next = null;
    }
}
// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
// HINT for the problem
// Note : use double linked list because deletion require O(1) time

public class Solution3 {
    public int mctFromLeafValues(int[] arr) {
        int ans = 0;
        Node head = new Node(100);
        Node p = head;
        for (int i = 0; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            temp.prev = p;
            p.next = temp;
            p = temp;
        }
        Node temp = new Node(100);
        temp.prev = p;
        p.next = temp;

        while (head.next.next.val != 100) {
            Node mini = findMinNode(head);
            ans += mini.val * Math.min(mini.prev.val, mini.next.val);
            remove(mini);
        }

        return ans;
    }

    private void remove(Node mini) {
        Node prev_node = mini.prev;
        prev_node.next = mini.next;
        mini.next.prev = prev_node;
    }

    private Node findMinNode(Node head) {
        Node p = head.next;
        Node mini = p;
        while (p != null) {
            if (p.val < mini.val)
                mini = p;
            p = p.next;
        }
        return mini;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n)