
//--------------------USING DOUBLE LINKED LIST
//NOTE : This DS is faster than stack 

class BrowserHistory {

    public class Node {
        String url;
        Node next, prev;

        public Node(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node temp = new Node(url);
        curr.next = temp;
        temp.prev = curr;
        curr = temp;
    }

    public String back(int steps) {
        while (curr.prev != null && steps-- > 0)
            curr = curr.prev;
        return curr.url;
    }

    public String forward(int steps) {
        while (curr.next != null && steps-- > 0)
            curr = curr.next;
        return curr.url;
    }
}
// Time complexity : O(n)
