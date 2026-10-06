class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans =  new ArrayList<>();
        if(digits.equals("")) return ans;
        String[] map = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(ans,new StringBuilder(),map,digits,0);
        return ans;
    }
    public void backtrack(List<String> ans,StringBuilder sb,String[] map,String digits,int index){
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(index)-'1'];
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            backtrack(ans,sb,map,digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}