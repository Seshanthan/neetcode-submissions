class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=nums[0];
        int sum=0;
        for(int num:nums){
            sum+=num;
            maxi=Math.max(maxi,sum);
            sum=Math.max(0,sum);
        }
        return maxi;
    }
}