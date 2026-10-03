/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Deque<TreeNode> q = new LinkedList<>();
        StringBuilder sb =  new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null){
                sb.append("n,");
                continue;
            }
            sb.append(String.valueOf(temp.val)+",");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        //System.out.print(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty()) return null;
        String[] ans= data.split(",");
        TreeNode root =  new TreeNode(Integer.parseInt(ans[0]));
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty() || i<ans.length){
            TreeNode temp=q.poll();
            if(!ans[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(ans[i]));
                temp.left=left;
                q.offer(left);
            }
            i++;
            if(i<ans.length && !ans[i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(ans[i]));
                temp.right=right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));