import java.util.*;

//-------------------------NIAVE APPROACH 

//--------------ALGO
/*
 * for every  char i have two option
 * either take it or not 
 * and keep track of right and left 
 * if both left and right ==0 at the end means valid string else not 
 */
class Solution {
    Set<String> set;

    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        int mr = getMinRemoval(s);
        f(s, mr);
        List<String> ans = new ArrayList<>();
        for (String i : set)
            ans.add(i);

        return ans;

    }

    public int getMinRemoval(String s) {
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
        return mr + open;
    }

    void f(String s, int mr) {
        if (mr == 0) {
            if (getMinRemoval(s) == 0)
                set.add(new String(s));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            f(left + right, mr - 1);
        }
    }

}