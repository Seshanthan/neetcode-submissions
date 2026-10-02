/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        int ans=dfs(root,root.val);
        return ans;
    }
    public int dfs(TreeNode root,int maxi){
        if(root==null) return 0;
        int count=0;
        if(root.val>=maxi){
            count=1;
        }
        maxi=Math.max(maxi,root.val);
        count+=dfs(root.left,maxi);
        count+=dfs(root.right,maxi);
        return count;
    }
}