import java.util.*;

class Solution {
    Set<String> dict;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        dict = new HashSet<>();
        for (String word : words)
            dict.add(word);
        for (String word : words) {
            dict.remove(word);
            if (f(0, word, new Boolean[word.length()]))
                res.add(word);
            dict.add(word);
        }
        return res;

    }

    boolean f(int ind, String word, Boolean dp[]) {
        if (ind >= word.length())
            return true;

        if (dp[ind] != null)
            return dp[ind];
        StringBuilder s = new StringBuilder();
        for (int i = ind; i < word.length(); i++) {
            s.append(word.charAt(i));
            if (dict.contains(s.toString())) {
                if (f(i + 1, word, dp))
                    return dp[ind] = true;
            }
        }

        return dp[ind] = false;
    }
}