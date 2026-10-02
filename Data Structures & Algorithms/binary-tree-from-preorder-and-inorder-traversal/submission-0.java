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
    // pre 3 9 20 15 7 root left right
    
    // in 9 3 15 20 7 left root right
    HashMap<Integer,Integer> h = new HashMap<>();
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        
        for(int i=0;i<n;i++){
            h.put(inorder[i],i);
        }
        return build(preorder,0,n-1);
    }
    public TreeNode build(int[] preorder,int left,int right){
        if(left>right) return null;
        int cur = preorder[idx++];
        TreeNode root = new TreeNode(cur);
        int index= h.get(cur);
        root.left = build(preorder,left,index-1);
        root.right = build(preorder,index+1,right);
        return root;
    }
}