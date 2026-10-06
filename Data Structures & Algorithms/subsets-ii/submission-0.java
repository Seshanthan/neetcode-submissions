class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(),nums,0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,List<Integer> current,int[] nums,int index){
        
        ans.add(new ArrayList<>(current));
         
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            current.add(nums[i]);
            backtrack(ans,current,nums,i+1);
            current.remove(current.size()-1);
        }
    }
}