import java.util.*;

class Solution {

    Set<ArrayList<Integer>> set;
    int MOD = (int) 1e9 + 7;

    public List<List<Integer>> fourSum(int[] arr, int x) {
        int n = arr.length;
        Arrays.sort(arr);
        set = new HashSet<>();
        for (int i = 0; i < n - 3; i++)
            for (int j = i + 1; j < n - 2; j++)
                findPair(j + 1, n - 1, arr, x, arr[i], arr[j]);
        return new ArrayList<>(set);
    }

    // ---O(n) function
    void findPair(int i, int j, int arr[], int x, int a, int b) {
        int sum = (a + b) % MOD;
        x = x - sum;
        while (i < j) {
            if (arr[i] + arr[j] > x)
                j--;
            else if (arr[i] + arr[j] < x)
                i++;
            else {
                set.add(new ArrayList<>(Arrays.asList(a, b, arr[i], arr[j])));
                j--;
                i++;
            }

        }

    }
}
// Time complexity : O(n^3)
// Space complexity : O(n)