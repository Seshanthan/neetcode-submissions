class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> h= new HashMap<>();
        for(String i:strs){
            char[] s = i.toCharArray();
            Arrays.sort(s);
            String k = new String(s);
            h.putIfAbsent(k,new ArrayList<>());
            h.get(k).add(i);
        }
        return new ArrayList<>(h.values());

    }
}
