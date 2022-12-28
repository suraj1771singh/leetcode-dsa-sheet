import java.util.*;

//--------------------BFS

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        HashSet<String> validWord = new HashSet<>(wordList);
        if (!validWord.contains(endWord))
            return 0;
        q.add(beginWord);
        seen.add(beginWord);
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            moves++;
            while (size-- > 0) {
                String word = q.poll();
                if (word.equals(endWord))
                    return moves;

                for (int i = 0; i < word.length(); i++) {
                    for (int j = 'a'; j <= 'z'; j++) {
                        char ch[] = word.toCharArray();
                        ch[i] = (char) j;

                        String str = new String(ch);
                        if (validWord.contains(str) && !seen.contains(str)) {
                            q.add(str);
                            seen.add(str);
                        }
                    }
                }

            }
        }
        return 0;
    }
}