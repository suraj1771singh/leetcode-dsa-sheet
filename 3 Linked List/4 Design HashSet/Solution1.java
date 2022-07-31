//---------------NAIVE SOLUTION

class MyHashSet {

    int arr[];

    public MyHashSet() {
        int n = (int) 1e6 + 1;
        arr = new int[n];
    }

    public void add(int key) {
        arr[key] = 1;

    }

    public void remove(int key) {
        arr[key] = 0;
    }

    public boolean contains(int key) {
        return arr[key] == 1;
    }
}
