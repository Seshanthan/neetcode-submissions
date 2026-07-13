class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i:nums){
            h.put(i,h.getOrDefault(i,0)+1);
        }
        List<Integer>[] b = new List[nums.length+1];
        for(int i:h.keySet()){
            int freq=h.get(i);
            if(b[freq]==null){
                b[freq]= new ArrayList<>();
            }
            b[freq].add(i);
        }
        int j=0;
        int[] ans = new int[k];

        for(int i=b.length-1;i>0 && j<k;i-- ){
            if(b[i]!=null){
                for(int x:b[i]){
                    ans[j++]=x;
                    if(j>k) break;
                }
            }
        }
        return ans;
    }
}
