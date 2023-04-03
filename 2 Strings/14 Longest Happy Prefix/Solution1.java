import java.util.*;

//-----------------NAIVE APPROACH

class Solution {
    public String longestPrefix(String s) {
        Set<String> prefix = new HashSet<>();
        Set<String> suffix = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            prefix.add(s.substring(0, i + 1));
            suffix.add(s.substring(i + 1, n));
        }
        System.out.println(prefix);
        System.out.println(suffix);
        String ans = "";
        for (String str : prefix) {
            if (suffix.contains(str) && ans.length() < str.length())
                ans = str;
        }
        return ans;

    }
}
// Time complexity : O(n^2)