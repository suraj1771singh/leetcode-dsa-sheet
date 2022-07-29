import java.util.*;

//-----------------------NAIVE APPROACH
class Solution1 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] > nums[j])
                    cnt++;
            count.add(cnt);
        }
        return count;

    }
}
// Time complexity : O(n^2)
// Space complexity : O(1)