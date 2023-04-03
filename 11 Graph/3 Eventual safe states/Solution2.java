import java.util.*;;

class Solution {

    List<Integer> eventualSafeNodes(int n, List<List<Integer>> adj) {

        Boolean mark[] = new Boolean[n];
        for(int i=0; i<n; i++){
            if(adj.get(i).size()==0) mark[i]=true;
        }
        for(int i=0; i<n; i++){
            if(mark[i]==null) mark[i]=dfs(i,adj,mark);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0; i<n; i++) if(mark[i]) res.add(i);
        return res;
        
    }
    Boolean dfs(int node,List<List<Integer>> adj,Boolean[]mark ){
        if(mark[node]!=null) return mark[node];
        mark[node]=false;
        for(int child : adj.get(node)){
            if(!dfs(child,adj,mark)) return false;
        }
        mark[node]=true;
        return true;
    }
}
//Time complexity : O(V+E)