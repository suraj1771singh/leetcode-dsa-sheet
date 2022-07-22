import java.util.*;

//-----------NAIVE APPROACH

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<Map<Character, Integer>> arr = new ArrayList<>();

        // -preprocessing
        for (String s : strs) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            arr.add(map);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String a = strs[i];
            if (a.equals("*"))
                continue;
            ArrayList<String> temp = new ArrayList<>();
            temp.add(a);
            strs[i] = "*";
            for (int j = i + 1; j < strs.length; j++) {
                String b = strs[j];
                if (b.equals("*"))
                    continue;
                if (isAnagram(i, j, arr)) {
                    temp.add(b);
                    strs[j] = "*";
                }
            }
            ans.add(temp);
        }
        return ans;

    }

    private boolean isAnagram(int i, int j, ArrayList<Map<Character, Integer>> arr) {
        if (arr.get(i).size() != arr.get(j).size())
            return false;
        for (Character c : arr.get(i).keySet()) {
            if (!arr.get(j).containsKey(c) || arr.get(j).get(c) != arr.get(i).get(c))
                return false;
        }
        return true;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n)