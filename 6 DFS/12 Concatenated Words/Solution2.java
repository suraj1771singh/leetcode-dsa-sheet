import java.util.*;

//-------------------MEMOIZATION
//NOTE : similar to word break problem

class Solution2 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String s : words)
            set.add(s);
        for (String s : words) {
            int dp[] = new int[s.length()];
            Arrays.fill(dp, -1);
            if (dfs(s, 0, 0, set, dp))
                list.add(s);
        }
        return list;

    }

    private boolean dfs(String s, int ind, int count, Set<String> set, int dp[]) {
        if (ind == s.length()) {
            if (count > 1)
                return true;
            else
                return false;
        }

        if (dp[ind] != -1)
            return dp[ind] == 1 ? true : false;
        for (int i = ind; i < s.length(); i++) {
            if (set.contains(s.substring(ind, i + 1))) {
                if (dfs(s, i + 1, count + 1, set, dp)) {
                    dp[ind] = 1;
                    return true;
                }

            }
        }
        dp[ind] = 0;
        return false;
    }
}