import java.util.*;

//-----------OPTIMISED VERSION

//sliding window technique and HashSet
/*
 The idea is use a hash set to track the longest substring without 
 repeating characters so far, use a fast pointer j to see if character 
 j is in the hash set or not, if not, great, add it to the hash set, 
 move j forward and update the max length, otherwise, delete from the 
 head by using a slow pointer i until we can put character j to the hash set.

 */

class Solution2 {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;

    }
}
// Time complexity : O(n)
// Space complexity : O(1)
