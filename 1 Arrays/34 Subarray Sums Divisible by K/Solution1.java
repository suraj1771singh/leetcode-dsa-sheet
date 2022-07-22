import java.util.HashMap;

//-------EFFICIENT APPROACH
//-----ALGO
/*
  1) find modulo of each element
  2) count number of subarrays with sum 0 or k 

 */
class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] = nums[i] % k + k;
            else
                nums[i] = nums[i] % k;
        }
        // find subarrays whoes sum is either 0 or k
        return subarraySum(nums, k);

    }

    private int subarraySum(int[] a, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i : a) {
            sum += i;
            sum %= k;
            if (map.containsKey(sum - k)) // when sum is k
                count += map.get(sum - k);

            if (map.containsKey(sum))// when sum is 0
                count += map.get(sum);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

// Time complexity : O(n)
// Space complexity : O(k) constant space complexity