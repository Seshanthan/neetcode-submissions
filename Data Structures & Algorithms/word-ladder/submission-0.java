class Solution {
    public int ladderLength(String b, String e, List<String> wl) {
        Set<String> w = new HashSet<>(wl);
        if(!w.contains(e)) return 0;
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> vis= new HashSet<>();
        q.offer(b);
        vis.add(b);
        int steps=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur =  q.poll();
                if(cur.equals(e)){
                    return steps;
                }
                char[] arr = cur.toCharArray();
                for(int j =0;j<arr.length;j++){
                    char temp=arr[j];
                    for(char k='a';k<='z';k++){
                        if(k==temp) continue;
                        arr[j]=k;
                        String mod= new String(arr);
                        if(w.contains(mod) && vis.add(mod)){
                            q.offer(mod);
                        }
                        arr[j]=temp;
                    }

                }

            }steps++;
            

        }
        return 0;
    }
}