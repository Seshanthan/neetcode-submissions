class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuilder(),n,0,0);
        return ans;
    }
    public void backtrack(List<String> ans, StringBuilder sb,int n,int c,int d){
        if(sb.length()==2*n){
            StringBuilder s = new StringBuilder(sb);
            ans.add(s.toString());
            return;
        }
        
        if(c<n){
            sb.append("(");
            backtrack(ans,sb,n,c+1,d);
            sb.deleteCharAt(sb.length()-1);
        }
        if(d<c){
            sb.append(")");
            backtrack(ans,sb,n,c,d+1);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}