class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String i:strs){
            sb.append((char) i.length()).append('#').append(i);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            int len=str.charAt(i);
            if(str.charAt(i+1)=='#'){
                StringBuilder sb = new StringBuilder();
                for(int j=i+2;j<i+2+len;j++){
                    sb.append(str.charAt(j));
                }
                ans.add(sb.toString());
            }
            i=i+1+len;
        }
        return ans;
    }
}
