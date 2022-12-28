import java.util.*;

class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        List<List<Integer>> adj= new ArrayList<>();
        HashSet<String> set= new HashSet<>();
        int indegree[] = new int[n];
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int edge[] : relations){
            int u =edge[0]-1;
            int v = edge[1]-1;
            set.add(u+"-"+v);
            adj.get(edge[0]-1).add(edge[1]-1);
            indegree[edge[1]-1]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0) q.add(i);
        }
        int sem=0;
        int ind=0;
        int []topo= new int[n];
        while(!q.isEmpty()){
            int node= q.poll();
            topo[ind++]=node;
            for(int u : adj.get(node)){
                indegree[u]--;
                if(indegree[u]==0) q.add(u);
            }
            
        }
        
        
        System.out.println(Arrays.toString(topo));
        return sem;
    }
}