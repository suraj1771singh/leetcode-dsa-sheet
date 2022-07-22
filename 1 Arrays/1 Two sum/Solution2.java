import java.util.HashMap;
import java.util.Map;

//-using hashmap to reduce searching time for 2nd number of pair

public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}

// Time complexity : O(n)
// Space complexity : O(n)