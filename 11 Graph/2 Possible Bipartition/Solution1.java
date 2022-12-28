class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //create adj list
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<dislikes.length; i++){
            int u=dislikes[i][0];
            int v=dislikes[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int color[]= new int[n+1];
        for(int i=1; i<=n; i++){
            if(color[i]==0 && !isBipartite(i,n,color,adj)) return false;
        }
        return true;
    }
    public boolean isBipartite(int src, int n, int[] color,List<List<Integer>> adj){
        color[src]=1;
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node= q.poll();
            for(int u : adj.get(node)){
                if(color[u]==0){
                    color[u]=color[node]*-1;
                    q.add(u);
                }else if(color[u]==color[node]) return false;
            }
        }
        return true;
    }

}