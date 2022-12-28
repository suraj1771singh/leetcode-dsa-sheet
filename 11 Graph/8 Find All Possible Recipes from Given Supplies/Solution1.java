import java.util.*;

//--------------USING TOPOSORT
//----ALGO
/*
1) consider different supplies and ingredients as nodes of graph, and create directed graph
2) then use topo sort and store those nodes in set(reachable nodes)
3) traverse through set and check weather it is present or not in set (can receipe made or not)
*/
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int cnt = 0;
        // ------ mapping string along integer(as graph node)
        for (String s : supplies) {
            if (!map.containsKey(s)) {
                map.put(s, cnt);
                cnt++;
            }
        }
        for (int i = 0; i < ingredients.size(); i++) {
            for (String s : ingredients.get(i)) {
                if (!map.containsKey(s)) {
                    map.put(s, cnt);
                    cnt++;
                }
            }
        }
        for (String s : recipes) {
            if (!map.containsKey(s)) {
                map.put(s, cnt);
                cnt++;
            }
        }
        // -------------------
        // Creating adj list of graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < cnt; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < ingredients.size(); i++) {
            for (String s : ingredients.get(i)) {
                adj.get(map.get(s)).add(map.get(recipes[i]));
            }
        }
        // calculating indegree
        int indegree[] = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            for (int u : adj.get(i))
                indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        // start with supplies
        for (String s : supplies)
            q.add(map.get(s));

        Set<Integer> isToposort = new HashSet<>();// contains topological sort order
        while (!q.isEmpty()) {
            int node = q.poll();
            isToposort.add(node);
            for (int u : adj.get(node)) {
                indegree[u]--;
                if (indegree[u] == 0)
                    q.add(u);
            }
        }
        for (String s : recipes) {
            if (isToposort.contains(map.get(s)))
                res.add(s);
        }
        return res;

    }
}
// Time complexity : O(n) n : all indegredients, and supplies