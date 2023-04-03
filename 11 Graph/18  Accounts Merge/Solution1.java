import java.util.*;

class Solution {
    int parent[];

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        int n = accounts.size();
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (map.containsKey(email)) {
                    union(map.get(email), i);
                } else
                    map.put(email, i);
            }
        }
        Map<Integer, List<String>> email = new HashMap<>();
        for (String key : map.keySet()) {
            int val = map.get(key);
            val = find(val);
            if (!email.containsKey(val))
                email.put(val, new ArrayList<String>());
            email.get(val).add(key);
        }
        List<List<String>> res = new ArrayList<>();
        for (int key : email.keySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(key).get(0));
            temp.addAll(email.get(key));
            res.add(temp);

        }
        return res;

    }

    int find(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return;
        parent[pu] = pv;
    }
}