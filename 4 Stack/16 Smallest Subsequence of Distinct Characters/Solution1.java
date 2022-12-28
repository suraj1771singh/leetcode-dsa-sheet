import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int map[] = new int[26];
        boolean seen[] = new boolean[26];

        for (int i = 0; i < n; i++)
            map[s.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > curr && !seen[curr - 'a'] && map[stack.peek() - 'a'] > 0)
                seen[stack.pop() - 'a'] = false;

            if (!seen[curr - 'a']) {
                stack.add(curr);
                seen[curr - 'a'] = true;

            }
            map[curr - 'a']--;
        }
        StringBuilder str = new StringBuilder();
        for (char c : stack)
            str.append(c);
        return str.toString();
    }
}