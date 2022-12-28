import java.util.*;
//-----------------BFS 

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();
        Queue<List<String>> q = new LinkedList<>();
        HashSet<String> usedUp = new HashSet<>();
        HashSet<String> validWords = new HashSet<>(wordList);
        HashSet<String> seen = new HashSet<>();
        if (!validWords.contains(endWord))
            return list;
        q.add(Arrays.asList(beginWord));
        seen.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            usedUp = new HashSet<>();
            while (size-- > 0) {
                List<String> currPath = q.poll();
                seen = new HashSet<>();
                String lastWord = currPath.get(currPath.size() - 1);

                for (int i = 0; i < lastWord.length(); i++) {
                    char ch[] = lastWord.toCharArray();
                    for (int j = 'a'; j <= 'z'; j++) {
                        ch[i] = (char) j;
                        String nextWord = new String(ch);
                        if(nextWord.equals(lastWord))  continue;
                        if (validWords.contains(nextWord)) {
                            seen.add(nextWord);
                            // create new path
                            List<String> newPath = new ArrayList<>(currPath);
                            newPath.add(nextWord);
                            usedUp.add(nextWord);
                            if (nextWord.equals(endWord))
                                list.add(newPath);
                            else
                                q.add(newPath);
                        }
                    }
                }

            }
            for (String word : usedUp)
                validWords.remove(word);
            if (list.size() > 0)
                return list;
        }
        return list;
    }
}