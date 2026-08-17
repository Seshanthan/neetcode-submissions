class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=  new int[26];
        int[] freq1=  new int[26];
        int c=0;
        for(char i: s1.toCharArray()){
            freq[i-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            freq1[s2.charAt(i)-'a']++;
            if(i>=s1.length()){
                freq1[s2.charAt(i-s1.length())-'a']--;
            }
            if(Arrays.equals(freq,freq1)) return true;
        }
        return false;
    }
}