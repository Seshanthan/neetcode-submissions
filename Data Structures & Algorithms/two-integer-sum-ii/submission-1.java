class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target){
                return new int[]{i+1,j+1};
            }
            else if(nums[i]+nums[j]>target){
                j--;
            }
            else if(i+1==j || nums[i]+nums[j]<target){
                i=i+1;
                j=nums.length-1;
            }
        }
        return new int[]{};
    }
}
