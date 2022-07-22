import java.util.HashMap;

//--------NIAVE SOLUTION

//using hashmap

class Solution {
    public int firstMissingPositive(int[] nums) {
        int maxi_num = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.putIfAbsent(i, 1);
            maxi_num = Math.max(maxi_num, i + 1);
        }
        // check for the number from 1 to maxi_num
        for (int i = 1; i < maxi_num; i++) {
            if (!map.containsKey(i))
                return i;
        }
        return maxi_num;
    }
}
// Time complexity : O( max(n, maxi_num) )
// Space complexity : O(n)