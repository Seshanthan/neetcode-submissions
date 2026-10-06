class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(),nums,0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,List<Integer> current,int[] nums,int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(ans,current,nums,index+1);
        current.remove(current.size()-1);
        backtrack(ans,current,nums,index+1);
    }
}