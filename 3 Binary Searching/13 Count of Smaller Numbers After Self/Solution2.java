import java.util.*;

//-----------------------EFFICIENT APPROACH
/*
 * 1) Think about merge sort , we do similar think during merging
 * 2) this problem is similar like count inversions in array
 */

public class Solution2 {
    HashMap<Integer, Integer> map;
    int cnt[];

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        map = new HashMap<>();
        cnt = new int[n];
        for (int i = 0; i < n; i++)
            map.put(i, nums[i]);
        mergeSort(nums, 0, n - 1);
        List<Integer> list = new ArrayList<>();
        for (int i : cnt)
            list.add(i);
        return list;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(nums, lo, mid);
            mergeSort(nums, mid + 1, hi);
            merge(nums, lo, mid, hi);
        }

    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int n1 = mid - lo + 1, n2 = hi - mid;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for (int i = 0; i < n1; i++)
            arr1[i] = nums[lo + i];

        for (int i = 0; i < n2; i++)
            arr2[i] = nums[mid + i + 1];

        int i = 0, j = 0, k = lo;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j])
                nums[k++] = arr1[i++];
            else {
                cnt[k] += j + 1;
                nums[k++] = arr2[j++];
            }
        }
        while (i < n1)
            nums[(int) k++] = arr1[(int) i++];
        while (j < n2)
            nums[(int) k++] = arr2[(int) j++];
    }
}
// Time complexity : O(n*log n)
// Space complexity : O(1)
