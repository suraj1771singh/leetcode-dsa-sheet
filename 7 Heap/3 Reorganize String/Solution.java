import java.util.HashMap;

import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        char ch[] = new char[n];
        // find max freq of the character
        int maxi = 0;
        char letter = 'a';
        for (char key : map.keySet()) {
            int val = map.get(key);
            if (maxi < val) {
                maxi = val;
                letter = key;
            }
        }
        if (maxi > (n + 1) / 2)
            return "";
        // else we can form desired string
        // put character at 1 index apart

        int ind = 0;
        int val = map.get(letter);
        while (val-- > 0) {
            ch[ind] = letter;
            ind += 2;
        }
        for (char key : map.keySet()) {
            if (key == letter)
                continue;
            val = map.get(key);
            while (val-- > 0) {
                if (ind >= n) {
                    ind = 1;
                }
                ch[ind] = key;
                ind += 2;
            }
        }
        for (char c : ch)
            System.out.print(c);
        return String.valueOf(ch);

    }
}