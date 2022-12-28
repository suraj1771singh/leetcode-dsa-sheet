import java.util.*;
//-------------BFS

class Solution {
    public int[][] updateMatrix(int[][] grid) {
        
        int dirs[][]= new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q= new LinkedList<>();
        int n= grid.length,m= grid[0].length;
        boolean seen[][]= new boolean[n][m];
        for(int i=0; i<n ; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    seen[i][j]=true;
                    grid[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size(); 
            dist++;
            while(size-->0){
                int cell[]=  q.poll();
                for(int dir[] : dirs){
                    int x= dir[0]+cell[0];
                    int y= dir[1]+cell[1];
                    if(x>=0 && x<n && y>=0 && y<m && !seen[x][y] ){
                        seen[x][y]=true;
                        grid[x][y]=dist;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
        return grid;
    }
}