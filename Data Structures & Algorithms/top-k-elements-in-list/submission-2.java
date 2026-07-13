class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i:nums){
            h.put(i,h.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> q= new PriorityQueue<>((a,b)-> h.get(b)-h.get(a));
        q.addAll(h.keySet());

        
        
        int[] ans = new int[k];
        int c=0;
        while(k>0){
            ans[c++]=q.poll();
            k--;
        }
        return ans;
    }
}
