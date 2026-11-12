class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] ind =  new int[numCourses];
        for(int[] i:p){
            adj.get(i[1]).add(i[0]);
            ind[i[0]]++;
        }
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(ind[i]==0){
                q.offer(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int node = q.poll();
            List<Integer> nei = adj.get(node);
            c++;
            for(int x:nei){
                ind[x]--;
                if(ind[x]==0){
                    q.offer(x);
                }
            }
        }
        return c==numCourses;
    }
}