
//--------MOST OPTMIZED VERSION

public class Solution3 {
    public String minRemoveToMakeValid(String s) {

        char[] arr = s.toCharArray();
        int open = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            if (arr[i] == '(')
                open++;
            else if (arr[i] == ')') {
                if (open == 0)
                    arr[i] = '*';
                else
                    open--;
            }
        }
        // remove invalid open '(' from end
        for (int i = n - 1; i >= 0; i--) {
            if (open > 0 && arr[i] == '(') {
                arr[i] = '*';
                open--;
            }
        }

        int p = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != '*')
                arr[p++] = arr[i];
        }

        return new String(arr).substring(0, p);
    }
}
// Time complexity : O(n)
// Spac complexity : O(n)
