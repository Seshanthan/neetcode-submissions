class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp= new int[nums.length+1];
        dp[0]=0;
        for(int i=1;i<=nums.length;i++){
            int take=nums[i-1];
            if(i>=2){
                take+=dp[i-2];
            }
            int skip=dp[i-1];
            dp[i]=Math.max(take,skip);
        }
        return dp[nums.length];
    }
}