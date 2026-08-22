class TimeMap {
    class Pair{
    int timestamp;
    String value;
    Pair(int timestamp,String value){
        this.timestamp=timestamp;
        this.value=value;
    }
    }
    HashMap<String,ArrayList<Pair>> map;
    public TimeMap() {
        map= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        ArrayList<Pair> list = map.get(key);
        int l=0;
        int h=list.size()-1;
        String ans="";
        while(l<=h){
            int mid=l+(h-l)/2;
            if(list.get(mid).timestamp<=timestamp){
                ans=list.get(mid).value;
                l=mid+1;
                
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */