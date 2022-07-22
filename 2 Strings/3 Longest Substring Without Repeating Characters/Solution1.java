import java.util.*;

//-------ALGO
/*
 * 1) using sliding window technique
 * 2) take a set to keep track of characters
 * 3) whenever we found duplicate character clear set and
 *    keep track of max size of set 
 * 
 */
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < n) {
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i++));
            else
                set.remove(s.charAt(j++));
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)