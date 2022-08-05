import java.util.HashMap;

//--------ALGO
/*
 * 1) Make a map, 
 * 2) there can be two cases 
 *    ----if key present
 *           --add that key at tail of DLL and update it's location in map
 *    ----if key not present
 *        -- size is full 
 *           --remove from head of DLL (LRU)
 *           --remove from hashmap LRU
 *           --add new key to tail and add in map also
 *        -- size is not ful
 *           -- add new key to tail and add in map
 *             
 *
 */

class LRUCache {
    class Node {
        int val;
        int key;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.val = val;
            this.key = key;
            prev = next = null;
        }
    }

    int size;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        size = capacity;
        head = null;
        tail = null;

    }

    public int get(int key) {
        int ans = 0;
        if (!map.containsKey(key))
            return -1;
        ans = map.get(key).val;
        // delete from DLL
        removeFromDLL(map.get(key));
        Node temp = new Node(key, ans);
        addAtTail(temp);
        map.put(key, temp);
        return ans;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // remove it from DLL
            removeFromDLL(map.get(key));
            // add at the tail;
            Node temp = new Node(key, value);
            addAtTail(temp);
            map.put(key, temp);
        } else {
            if (size == 0) {
                // remove LRU
                map.remove(head.key);
                removeFromDLL(head);
                size++;
            }

            Node temp = new Node(key, value);
            if (head == null) {
                head = tail = temp;
            } else
                addAtTail(temp);
            map.put(key, temp);
            size--;

        }

    }

    // utils
    public void removeFromDLL(Node node) {
        Node prevNode = node.prev;
        if (prevNode == null) {
            head = head.next;
        } else {
            prevNode.next = node.next;
        }
    }

    public void addAtTail(Node node) {
        if (tail != null) {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */