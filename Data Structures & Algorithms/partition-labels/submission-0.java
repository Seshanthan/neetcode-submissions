class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        List<Integer> ans = new ArrayList<>();
        int maxi=0;
        int prev=0;
        for(int i=0;i<s.length();i++){
            int cur = map.get(s.charAt(i));
            maxi=Math.max(maxi,cur);
            if(i==maxi){
                ans.add(maxi+1-prev);
                prev=maxi+1;
            }
        }
        return ans;
    }
}