import java.util.*;

//--USING MAX HEAP
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new int[] { i, freq[i] });
            }
        }
        StringBuilder str = new StringBuilder();
        while (!pq.isEmpty()) {
            int a[] = pq.poll();
            char c1 = (char) ('a' + a[0]);
            int cnt1 = a[1];
            int len = Math.min(repeatLimit, cnt1);
            for (int i = 0; i < len; i++)
                str.append(c1);

            if (cnt1 - len > 0) {
                if (!pq.isEmpty()) {
                    int b[] = pq.poll();
                    char c2 = (char) ('a' + b[0]);
                    int cnt2 = b[1];
                    str.append(c2);
                    pq.add(new int[] { a[0], cnt1 - len });
                    if (cnt2 - 1 > 0)
                        pq.add(new int[] { b[0], cnt2 - 1 });

                } else
                    return str.toString();

            }

        }
        return str.toString();
    }
}
// Time complexity : O(n*logn)