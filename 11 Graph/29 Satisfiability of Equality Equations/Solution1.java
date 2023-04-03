//    ----------UNION AND FIND
class Solution {
    int parent[];
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        for(int i=0; i<26; i++) parent[i]=i;
        for(String s : equations){
            int u = s.charAt(0)-'a';
            int v = s.charAt(3)-'a';
            if(s.charAt(1)=='='){
                union(u,v);
            }
        }
        for(String s : equations){
            int u = s.charAt(0)-'a';
            int v = s.charAt(3)-'a';
            if(s.charAt(1)=='!'){
                if(find(u)==find(v)) return false;
            }
        }
        return true;
    
        
    }
    int find(int u){
        if(u==parent[u]) return u;
        return parent[u]=find(parent[u]);
    }
    void union(int u, int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv) return;
        parent[pv]=pu;
    }
}