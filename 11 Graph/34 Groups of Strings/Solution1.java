import java.util.*;

//-----------------getting TLE

class Solution {
    int parent[];
    int sz[];
    int masks[];

    public int[] groupStrings(String[] words) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = words.length;
        parent = new int[n];
        sz = new int[n];
        Arrays.fill(sz, 1);
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int ans[] = new int[2];
        for (int i = 0; i < words.length; i++) {
            int mask = toMask(words[i]);
            map.putIfAbsent(mask, i);
            union(map.get(mask), i);
            // finding all connected mask

            Set<Integer> con_mask = new HashSet<>();
            for (int j = 0; j < 26; j++) {
                // add jth char if not present else delete it if present -> XOR operation
                con_mask.add(mask ^ (1 << j));
                // replace only if present
                if ((mask & (1 << j)) > 0) {
                    for (int k = 0; k < 26; k++) {
                        if ((mask & (1 << k)) == 0)
                            con_mask.add(mask ^ (1 << j) ^ (1 << k));// first delete then replace it
                    }
                }
            }

            // now union of all connected mask
            for (int mk : con_mask) {
                if (map.containsKey(mk))
                    union(map.get(mask), map.get(mk));
            }

        }
        for (int i = 0; i < words.length; i++)
            if (parent[i] == i) {
                ans[0]++;
                ans[1] = Math.max(ans[1], sz[i]);
            }
        return ans;
    }

    int toMask(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            mask = mask | 1 << (s.charAt(i) - 'a');
        }
        return mask;
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        if (p1 == p2)
            return;
        parent[p2] = p1;
        sz[p1] += sz[p2];
    }
}
// Time complexity :O(n*26*26)