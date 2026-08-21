class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        int ans=nums[0];
        while(l<=h){
            int mid = l+ (h-l)/2;
            if(nums[mid]<ans){
                ans=nums[mid];
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}