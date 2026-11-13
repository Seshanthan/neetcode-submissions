class Solution {
    public int countComponents(int n, int[][] edges) {
       
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                c++;
                dfs(adj,vis,i);
            }
        }
        return c;
    }
    public void dfs(List<List<Integer>> adj,boolean[] vis,int cur){
        vis[cur]=true;
        for(int nei:adj.get(cur)){ 
            if(!vis[nei]) dfs(adj,vis,nei);
        }
    }
}

