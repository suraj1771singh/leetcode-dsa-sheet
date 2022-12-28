class Solution {
    public int findKthLargest(int[] arr, int k) {
        int res = 0;
        k=arr.length-k+1;
        int l= 0, r=arr.length-1;
        
        while (k - 1 >= l && k - 1 <= r) {
            int pos = partition(arr, l, r, k);

            if (pos < k - 1) {
              
               l= pos + 1;
            } else if (pos > k - 1) {
                // check in left side
               r= pos - 1;
            } else {
                res = arr[pos];
                break;
            }
        }
        return res;
    }
     public static int partition(int[] arr, int l, int r, int k) {
        int i = l;
        Random random = new Random();
        int pivot = random.nextInt(r - l + 1) + l;
        swap(pivot, r, arr);//swapping pivot element in the last 
        pivot = r;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= arr[pivot]) {
                swap(i, j, arr);
                i++;
            }
        }
        // swap i with pivot
        swap(i, pivot, arr);
        return i;
    }

    public static void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}