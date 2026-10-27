class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int jump=0;
        int maxi=0;
        int curend=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]+i);
            if(curend==i){
                jump++;
                curend=maxi;
            }
            if(curend==nums.length-1){
                break;
            }
        }
        return jump;
    }
}