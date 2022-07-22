import java.util.*;

//-----------BACKTRACKING SOLUTION

class Solution1 {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        f(0, 0, new StringBuilder(), n);
        return ans;

    }

    public void f(int open, int close, StringBuilder s, int n) {
        if (s.length() == 2 * n) {
            ans.add(new String(s));
            return;
        }
        if (open < n) {
            s.append('(');
            f(open + 1, close, s, n);
            s.setLength(s.length() - 1);

        }

        if (open > close) {
            s.append(')');
            f(open, close + 1, s, n);
            s.setLength(s.length() - 1);
        }
    }

}
// Time complexity : O(2^2n)
// Space complexity :O(2*n)
