class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }   
            }
        }
        int[][] dir ={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i=cur[0];
            int j=cur[1];
            for(int[] d:dir){
                int di=i+d[0];
                int dj=j+d[1];
                if(di<0 || dj<0 || di>n-1 || dj>m-1) continue;
                if(grid[di][dj]!=Integer.MAX_VALUE){
                    continue;
                }
                grid[di][dj]=1+grid[i][j];
                q.offer(new int[]{di,dj});
            }
        }

    }
    
}
