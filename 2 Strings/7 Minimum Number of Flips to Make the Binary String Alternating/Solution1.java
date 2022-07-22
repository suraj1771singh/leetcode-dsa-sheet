//----------NAIVE SOLUTION
//------ALGO
/*
 1) use sliding window technique to mutate adding of first element to last
 2) first append s+=s 
 3) now make an window of size n and check 
    a=number of flips to convert it into 010101
    b=number of flips to convert it int0 101010
    ans=min(a,b)
    reapeat to step n times 

 */
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s1.append(1);
                s2.append(0);
            } else {
                s1.append(0);
                s2.append(1);
            }
        }
        s += s;
        int ans = (int) 1e9;
        for (int i = 0; i <= n; i++) {
            String temp = s.substring(i, i + n);
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                // 1010101...
                if (temp.charAt(j) != s1.charAt(j))
                    a++;
                // 0101010....
                if (temp.charAt(j) != s2.charAt(j))
                    b++;
            }
            ans = Math.min(ans, Math.min(a, b));
        }
        return ans;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n)