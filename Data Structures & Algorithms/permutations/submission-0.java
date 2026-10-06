class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(),nums);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,List<Integer> current,int[] nums){
        if(current.size()==nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(current.contains(nums[i])) continue;
            current.add(nums[i]);
            backtrack(ans,current,nums);
            current.remove(current.size()-1);
        }
    }
}