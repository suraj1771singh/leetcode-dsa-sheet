

import java.util.*;

//------------EFFICIENT SOLUTION

public class Solution2 {
    int MOD = (int) 1e9 + 7;
    HashSet<ArrayList<Integer>> set;

    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int x) {
        int n = arr.length;
        Arrays.sort(arr);
        set = new LinkedHashSet<>();
        for (int i = 0; i < n - 3; i++)
            for (int j = i + 1; j < n - 2; j++)
                findPair(j + 1, n - 1, arr, x, arr[i], arr[j]);
        return new ArrayList<>(set);
    }

    // ---O(n) function
    void findPair(int i, int j, int arr[], int x, int a, int b) {
        while (i < j) {
            if (a + b + arr[i] + arr[j] > x)
                j--;
            else if (a + b + arr[i] + arr[j] < x)
                i++;
            else {
                set.add(new ArrayList<>(Arrays.asList(a, b, arr[i], arr[j])));
                j--;
            }

        }
    }

}
// Time complexity : O(n^3)
// Space complexity : O(n)
