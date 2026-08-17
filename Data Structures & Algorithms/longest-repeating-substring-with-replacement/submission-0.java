class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int maxi=0;
        int[] freq= new int[26];
        int ans=0;
        for(int r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            maxi=Math.max(maxi,freq[s.charAt(r)-'A']);
            while(r-l+1-maxi>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans =Math.max(maxi,r-l+1);
        }
        return ans;
    }
}