import java.util.*;

//---------------USING CONCEPT OF HASHSET
//NOTE : use chain hashing, and linked list

class MyHashSet {

    List<List<Integer>> arr;

    public MyHashSet() {
        arr = new LinkedList<>();
    }

    public void add(int key) {

    }

    public void remove(int key) {

    }

    public boolean contains(int key) {

    }

    // utils
    public int hashIndex(int key) {
        return key % 100;
    }
}