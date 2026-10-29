class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int cur=dfs(grid,i,j,n,m);
                    ans=Math.max(ans,cur);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,int i,int j,int n,int m){
        if(i>n-1 || j>m-1 || i<0 || j<0 || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+dfs(grid,i,j-1,n,m) + dfs(grid,i-1,j,n,m)+dfs(grid,i+1,j,n,m)+dfs(grid,i,j+1,n,m);

    }
}