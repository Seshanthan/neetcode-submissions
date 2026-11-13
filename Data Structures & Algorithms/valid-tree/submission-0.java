class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        if(!dfs(adj,vis,0,-1)){
            return false;
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adj,boolean[] vis,int cur,int par){
        vis[cur]=true;
        for(int nei:adj.get(cur)){
            if(par==nei) continue; 
            if(vis[nei]) return false;
            if(!dfs(adj,vis,nei,cur)){
                return false;
            }
        }
        return true;
    }
}
