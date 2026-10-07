class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int[] point:points){
            int x=point[0];
            int y=point[1];
            int d=x*x+y*y;
            pq.offer(new int[]{d,x,y});
            if(pq.size()>k) pq.poll();
        }
        int[][] ans =  new int[pq.size()][2];
        int c=0;
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            ans[c][0]=temp[1];
            ans[c][1]=temp[2];
            c++;
        }
        return ans;
    }
}