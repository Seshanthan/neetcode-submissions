class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        while(map.size()>0){
            int start = map.firstKey();
            map.put(start,map.get(start)-1);
            if(map.get(start)==0) map.remove(start);
            int c=groupSize-1;
            while(c>0){
                start++;
                if(map.containsKey(start)){
                    map.put(start,map.get(start)-1);
                    if(map.get(start)==0) map.remove(start);
                    c--;
                }else{
                    return false;
                }
            }
        }
        return true;

    }
}