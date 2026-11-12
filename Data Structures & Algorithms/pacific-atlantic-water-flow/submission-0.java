class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        boolean[][] paci = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        for(int r=0;r<n;r++){
            dfs(heights,paci,r,0);
            dfs(heights,atl,r,m-1);
        }
        for(int c=0;c<m;c++){
            dfs(heights,paci,0,c);
            dfs(heights,atl,n-1,c);
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(paci[r][c] && atl[r][c]){
                    ans.add(Arrays.asList(r,c));
                }
            }
        }
        return ans;
        

    }
    public void dfs(int[][] heights,boolean[][] visited,int r,int c){
        if(r<0 || c<0 || r>heights.length-1 || c>heights[0].length-1 || visited[r][c]){
            return;
        }
        visited[r][c]=true;
        int[][] dir =  {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] d: dir){
            int nr = r+d[0];
            int nc=c+d[1];
            if(nr<0 || nc<0 || nr>heights.length-1 || nc>heights[0].length-1 || visited[nr][nc]){
            continue;
            }
            if(heights[nr][nc]>=heights[r][c]){
                dfs(heights,visited,nr,nc);
            }

        }

        
    }
}