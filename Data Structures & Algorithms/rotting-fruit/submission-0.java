class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    c++;
                }   
            }
        }
        int[][] dir ={{0,1},{1,0},{-1,0},{0,-1}};
        int time=0;
        while(!q.isEmpty() && c>0){
            int qn=q.size();
            time++;
            for(int x=0;x<qn;x++){
            int[] cur = q.poll();
            int i=cur[0];
            int j=cur[1];
            
            for(int[] d:dir){
                int di=i+d[0];
                int dj=j+d[1];
                if(di<0 || dj<0 || di>n-1 || dj>m-1 ) continue;
                if(grid[di][dj]!=1){
                    continue;
                }
                grid[di][dj]=2;
                c--;
                q.offer(new int[]{di,dj});
            }
            }
        }
        return c==0?time:-1;

    }
    
}
