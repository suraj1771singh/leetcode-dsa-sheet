import java.util.*;
//-------------USING PRIORITY QUEUE
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Fraction> pq = new PriorityQueue<>((a, b) -> Double.compare(a.ratio, b.ratio));
        int n = arr.length;
        for (int i = 0; i < n; i++)
            pq.add(new Fraction(((double) arr[i]) / arr[n - 1], i, n - 1));

        k--;
        while (k-- > 0) {
            Fraction f = pq.poll();
            if (f.i < f.j - 1)
                pq.add(new Fraction(((double) arr[f.i]) / arr[f.j - 1], f.i, f.j - 1));
        }
        Fraction f = pq.peek();
        int ans[] = new int[2];
        ans[0] = arr[f.i];
        ans[1] = arr[f.j];
        return ans;

    }
}

class Fraction {
    double ratio;
    int i;
    int j;

    Fraction(double a, int b, int c) {
        ratio = a;
        i = b;
        j = c;
    }
}

// Time complexity : O((n+k)*logn)
// Space complexity : O(n)