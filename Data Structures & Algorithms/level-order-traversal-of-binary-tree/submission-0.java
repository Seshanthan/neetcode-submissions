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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode cur=queue.poll();
                sub.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}

