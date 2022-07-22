import java.util.HashMap;

//-----EFFICIENT
//------ALGO

/*
=>First we will create map for counting frequencies of each element in the array.
=>Now we have 2 cases over here as
  -->a) if k == 0 it means we need to count frequency of the same element by using map.get(i) method.
  -->b) we need to take counter approach for every element by adding k everytime and check whether that element is present in map or not.
=>Instead of iterating through array, we will iterate through map.keySet() for getting unique elements.*/

public class Solution2 {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (int i : map.keySet()) {
            if ((k > 0 && map.containsKey(i + k)) || (k == 0 && map.get(i) > 1))
                ans++;
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)
