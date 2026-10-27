class Solution {
    public boolean checkValidString(String s) {
        int maxopen =0;
        int minopen =0;
        for(char i:s.toCharArray()){
            if(i=='('){
                maxopen++;
                minopen++;
            }else if(i==')'){
                maxopen--;
                minopen--;
            }else{
                maxopen++;
                minopen--;
            }
            if(maxopen<0){
                return false;
            }
            if(minopen<0) minopen=0;
        }
        
        return minopen==0;
    }
}