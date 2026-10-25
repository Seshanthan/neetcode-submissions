class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[][] sortQ = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            sortQ[i][0]=queries[i];
            sortQ[i][1]=i;
        }
        Arrays.sort(sortQ,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int[] ans = new int[queries.length];
        Arrays.fill(ans,-1);
        int i=0;
        for(int[] query:sortQ){
            int ind=query[1];
            int q=query[0];
            while(i<intervals.length && intervals[i][0]<=q){
                int len = intervals[i][1]-intervals[i][0]+1;
                pq.offer(new int[]{len, intervals[i][1]});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1]<q){
                pq.poll();
            }
            if(pq.size()>0){
                ans[ind]=pq.peek()[0];
            }
            
        }
        return ans;
    }
}