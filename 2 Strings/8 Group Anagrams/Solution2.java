import java.util.*;
import java.util.ArrayList;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char freq[] = new char[26];
            for (char c : s.toCharArray())
                freq[c - 'a']++;
            String a = String.valueOf(freq);
            ArrayList<String> temp = map.getOrDefault(a, new ArrayList<>());
            temp.add(s);
            map.put(a, temp);
        }
        return new ArrayList<>(map.values());
    }
}
// Time complexity : (total number of chars in strs)
// Space complexity : O(n)
