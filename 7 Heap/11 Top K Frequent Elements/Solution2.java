import java.util.*;

//----------USING BUCKET SORT

class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[k];
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> bucket[] = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int ind = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    ans[ind++] = j;
                    if (ind == k)
                        return ans;
                }
            }
        }
        return ans;

    }
}
// Time complexity : O(n)