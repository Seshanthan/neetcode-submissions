class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length==1) return (int) Math.ceil((double) piles[0]/(double)h);
        int maxi=Integer.MIN_VALUE;
        for(int i:piles){
            maxi=Math.max(maxi,i);
        }
        if(piles.length == h) return maxi;
        int ans=0;
        int l=1;
        int hi=maxi;
        while(l<=hi){
            int mid=l+(hi-l)/2;
            long sum=0;
            for(int i=0;i<piles.length;i++){
                sum+=(piles[i]+mid-1)/mid;
            }
            if(sum>h){
                l=mid+1;
            }
            else if(sum<=h){
                ans=mid;
                hi=mid-1;
            }
        }
        return ans;
    }
}