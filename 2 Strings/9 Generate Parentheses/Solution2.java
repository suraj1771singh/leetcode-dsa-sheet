import java.util.*;

//-----------BACKTRACKING OPTMIZED  SOLUTION

//NOTE : use char array instead , because it is faster

class Solution2 {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<String>();
        char[] s = new char[2 * n];
        f(0, 0, 0, s, n);
        return ans;

    }

    public void f(int open, int close, int ind, char[] s, int n) {
        if (ind == 2 * n) {
            ans.add(String.copyValueOf(s));
            return;
        }
        if (open < n) {
            s[ind] = '(';
            f(open + 1, close, ind + 1, s, n);

        }

        if (open > close) {
            s[ind] = ')';
            f(open, close + 1, ind + 1, s, n);
        }
    }

}
// Time complexity : O(2^2n)
// Space complexity :O(2*n)
