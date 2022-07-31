import java.util.Arrays;

//--------------------NAIVE SOLUTION

class MyHashMap {
    int arr[];

    public MyHashMap() {
        int n = (int) 1e6 + 1;
        arr = new int[n];
        Arrays.fill(arr, -1);

    }

    public void put(int key, int value) {
        arr[key] = value;

    }

    public int get(int key) {
        return arr[key];

    }

    public void remove(int key) {
        arr[key] = -1;
    }
}