class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> h= new HashMap<>();
        for(char i: s.toCharArray()){
            h.put(i,h.getOrDefault(i,0)+1);
        }
        for(char i: t.toCharArray()){
            h.put(i,h.getOrDefault(i,0)-1);
        }
        for(int i: h.values()){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
