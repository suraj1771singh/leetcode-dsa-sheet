import java.util.*;

//-------------VERY NAIVE SOLUTION

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int x) {
        int n = arr.length;
        Set<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int a = arr[i] + arr[j] + arr[k] + arr[l];
                        if (a == x) {
                            set.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l])));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
// Time complexity : O(n^4)
// Space complexity : O(1)