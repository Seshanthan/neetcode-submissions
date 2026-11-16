class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for(int i=1;i<parent.length;i++){
            parent[i]=i;
        }
        for(int[] e:edges){
            int p1=find(e[0]);
            int p2=find(e[1]);
            if(p1==p2) return e;
            parent[p1]=p2;
        }
        return new int[]{};
    }
    public int find(int e){
        if(e!=parent[e]){
            parent[e]=find(parent[e]);
        }
        return parent[e];
    }
}