
//-------SPACE OPTMIZED 
//---ALGO
/*
 * 1) use concept of moore's algo
 * 2) let open=0, ans=0;
 * 3) if s[i]=='(' => open++;
 * 4) if s[i]==')'=> open-- and if open<0 then ans++; ;
 * 5) return  ans+=open
 */

public class Solution2 {
    public int minAddToMakeValid(String s) {
        int ans = 0, open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                open++;
            else
                open--;
            if (open < 0) {
                ans++;
                open = 0;
            }
        }
        ans += open;
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)
