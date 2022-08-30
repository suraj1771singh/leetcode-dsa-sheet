import java.util.*;

//-------------------NAIVE (RECURSIVE SOLUTION)

class Solution2 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String s : words)
            set.add(s);
        for (String s : words) {
            if (dfs(s, 0, 0, set))
                list.add(s);
        }
        return list;

    }

    private boolean dfs(String s, int ind, int count, Set<String> set) {
        if (ind == s.length() && count > 1)
            return true;
        for (int i = ind; i < s.length(); i++) {
            if (set.contains(s.substring(ind, i + 1))) {
                if (dfs(s, i + 1, count + 1, set))
                    return true;

            }
        }
        return false;
    }
}