class Solution {
    public int maxArea(int[] h) {
        int i=0;
        int j=h.length-1;
        int ans=0;
        while(i<j){
            int minh=Math.min(h[i],h[j]);
            int d=j-i;
            ans= Math.max(ans,minh*d);
            if(i<j && h[i]<=h[j]) i++;
            else if(i<j && h[j]<=h[i]) j--;
            
            

        }
        return ans;
    }
}