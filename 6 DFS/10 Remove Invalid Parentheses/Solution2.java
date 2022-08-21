import java.util.*;

class Solution2 {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        ArrayList<String> validString = new ArrayList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();
                if (isValid(curr))
                    validString.add(curr);
                if (validString.isEmpty()) {
                    // go to next level
                    for (int i = 0; i < curr.length(); i++) {
                        if (curr.charAt(i) == '(' || curr.charAt(i) == ')') {
                            String adj = curr.substring(0, i) + curr.substring(i + 1);
                            if (!visited.contains(adj)) {
                                visited.add(adj);
                                q.offer(adj);
                            }
                        }
                    }
                }
            }
            if (!validString.isEmpty())
                return validString;
        }
        return validString;

    }

    public boolean isValid(String s) {
        int open = 0, mr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                open--;
                if (open < 0) {
                    mr += -1 * open;
                    open = 0;
                }
            }
        }
        return mr + open == 0 ? true : false;
    }
}
