class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            if(a==b) continue;
            else if(a>b) pq.offer(a-b);
            else pq.offer(b-a);
        }
        return pq.peek()==null?0:pq.peek();
    }
}