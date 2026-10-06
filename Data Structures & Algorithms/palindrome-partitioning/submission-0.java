class Solution {
    public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            backtrack(ans, new ArrayList<>(), s, 0);
            return ans;
    }

    public void backtrack(List<List<String>> ans,
                           List<String> current,
                           String s, int index) {
        if(index==s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s.substring(index,i+1))){
                current.add(s.substring(index,i+1));
                backtrack(ans, current, s, i + 1);
                current.remove(current.size() - 1);
            }
            
        }
    }
    public boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
