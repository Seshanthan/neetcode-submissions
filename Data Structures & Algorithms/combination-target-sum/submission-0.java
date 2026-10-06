class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(),0,candidates,0,target);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,List<Integer> current,int sum, int[] candidates,int index,int target){
        if(index==candidates.length){
            if(sum==target) ans.add(new ArrayList<>(current));
            return;
        }
        if(sum>target || index>=candidates.length) return;
        current.add(candidates[index]);
        sum+=candidates[index];
        backtrack(ans,current,sum,candidates,index,target);
        current.remove(current.size()-1);
        sum-=candidates[index];
        backtrack(ans,current,sum,candidates,index+1,target);
    }
}