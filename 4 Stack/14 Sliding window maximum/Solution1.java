import java.util.*;
//-------------------USING MONOTONIC STACK 
class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;

        // finding next greater element
        Stack<Integer> s = new Stack<Integer>();
        int nextgreater[] = new int[n];
        Arrays.fill(nextgreater, -1);
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && a[s.peek()] < a[i])
                nextgreater[s.pop()] = i;
            s.push(i);
        }

        // getting max for first k elements
        int maxi = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < k; i++)
            if (a[maxi] < a[i])
                maxi = i;

        ans.add(a[maxi]);

        int l = 0, r = k - 1;
        int curr = k;
        while (curr < n) {
            if (a[maxi] <= a[curr])
                maxi = curr;

            else if (maxi == l && a[maxi] > a[curr]) {
                int g = l + 1;
                maxi = g;
                while (g != -1 && g <= curr) {
                    maxi = g;
                    g = nextgreater[g];
                }
            }
            ans.add(a[maxi]);
            l++;
            r++;
            curr++;

        }
        int res[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);

        return res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)