class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int i:nums){
            h.add(i);
        }
        int maxi= 0;
        for(int i:nums){
            if(!h.contains(i-1)){
                int len=1;
                while(h.contains(i+1)){
                    len++;
                    i++;
                }
                maxi=Math.max(maxi,len);
            }
        }
        return maxi;
    }
}
