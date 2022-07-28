//---------------------------BINARY SEARCH

class Solution {
    public int shipWithinDays(int[] w, int d) {
         int maxi = -1, sum = 0;
         for (int i : w) {
             sum += i;
             maxi = Math.max(i, maxi);
         }
         // we know i.e we have to apply binary seach in range [maxi, sum]
         int l = maxi, r = sum;
         while (l <= r) {
             int mid = (l + r) / 2;
             if (isFeasible(w, d, mid))
                 r = mid - 1;
             else
                 l = mid + 1;
         }
         return l;
 
     }
 
     // checking wheather target is feasible or not
     // there should atmost d days req cannot be greater than d
     public boolean isFeasible(int[] w, int d, int target) {
         int req = 1, sum = 0;
         for (int i : w) {
             if (i + sum > target) {
                 req++;
                 sum = i;
             } else {
                 sum += i;
             }
         }
         return req <= d;
     }
 }
 //Time complexity : O(n*logn )
 //Space complexity : O(1)