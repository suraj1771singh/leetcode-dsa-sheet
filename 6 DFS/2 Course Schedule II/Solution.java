import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createAdj(adj, prerequisites, numCourses);
        ArrayList<Integer> temp = TopologicalSort(numCourses, adj);
        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        if (ans.length == numCourses)
            return ans;
        else
            return (new int[0]);

    }

    public void createAdj(ArrayList<ArrayList<Integer>> adj, int[][] prerequisites, int numCourses) {
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i : prerequisites) {
            adj.get(i[1]).add(i[0]);
        }
    }

    public ArrayList<Integer> TopologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        // caluculating indegree
        for (ArrayList<Integer> x : adj) {
            for (int i : x) {
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        addInQueue(q, indegree);
        while (!q.isEmpty()) {
            int item = q.poll();
            ans.add(item);
            for (int x : adj.get(item)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        return ans;

    }

    static public void addInQueue(Queue<Integer> q, int[] indegree) {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
    }
}